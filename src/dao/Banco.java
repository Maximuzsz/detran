/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Paulo
 */
public class Banco {
    
    public boolean inserir(String insert)
     {
       boolean retorno= false;
       PreparedStatement post = dao.Conexao.getPreparedStatement(insert);
       try 
       {
            post.executeUpdate();
            retorno = true;
        
       }
       catch(Exception ex)
       {
           ex.printStackTrace();
       }
       return retorno;
     }
    
    public Proprietario busca(Proprietario proprietario)
      {
        Proprietario prop = new Proprietario();
        String sql = "SELECT id_prop, prop_nome, prop_endereco from cadproprietario where prop_cpf=?";
        PreparedStatement pst = Conexao.getPreparedStatement(sql);
        
        try {
            pst.setString(1, proprietario.getCpf());
            ResultSet rs = pst.executeQuery();
            if(rs.next())
            {
                prop.setIdProprietario(rs.getInt("id_prop"));
                prop.setNomeProprietario(rs.getString("prop_nome"));
                prop.setEndereco(rs.getString("prop_endereco"));
             
            }
            
        } catch (Exception e) {
            e.printStackTrace();
            
        }
        return prop;
    }
    
    public String bCpf(int cpf)
      {
          String retorno="";
        String sql = "SELECT prop_cpf from cadproprietario where id_prop=?";
        PreparedStatement pst = Conexao.getPreparedStatement(sql);
        
        try {
            pst.setInt(1, cpf);
            ResultSet rs = pst.executeQuery();
            if(rs.next())
            {
              
               retorno = rs.getString("prop_cpf");
                
            }
            
        } catch (Exception e) {
            e.printStackTrace();
            
        }
        return retorno;
          
      }
    
    public boolean cadVeic(String insert,byte[] img)
     {
         boolean retorno= false;
         PreparedStatement post = dao.Conexao.getPreparedStatement(insert);
         try 
         {
              post.setBytes(1, img);
              post.executeUpdate();
              retorno = true;
         }
         catch(Exception ex)
         {
                     ex.printStackTrace();
         }  
         return retorno;
                    
     }
    
    public Veiculo buscaVeiculo(String  placa)
     {
        Veiculo carro  = new Veiculo();
        String sql = "SELECT idprop_veic, id_veic, modelo_veic, marca_veic, cor_veic, imagem_veic from cadveiculo where placa_veic=?";
        PreparedStatement pst = Conexao.getPreparedStatement(sql);
        
        try {
            pst.setString(1, placa);
            ResultSet rs = pst.executeQuery();
            if(rs.next())
            {
               carro.setIdprop(rs.getInt("idprop_veic"));
               carro.setIdveic(rs.getInt("id_veic"));
               carro.setModelo(rs.getString("modelo_veic"));
               carro.setMarca(rs.getString("marca_veic"));
               carro.setCor(rs.getString("cor_veic"));
               carro.setImagem(rs.getBytes("imagem_veic"));
          
            }
            
        } catch (Exception e) {
        }
        return carro;
          
      }
    public List<Multa> multa(int id)
      {
          
          String sql = "SELECT * FROM cadmulta where idveic_multa = ? ";
          PreparedStatement pst = Conexao.getPreparedStatement(sql);
          
          List<Multa> result = new ArrayList<>();

          try
          {
            pst.setInt(1, id);
            ResultSet rs = pst.executeQuery();
            while(rs.next())
           {
                Multa multa = new Multa();
                multa.setId_multa(rs.getInt("id_multa"));
                multa.setData(rs.getString("data_multa"));
                multa.setDesc_multa(rs.getString("descricao_multa"));
                
                result.add(multa);
                
            }
            
            
              
          } catch (Exception e) {
          }
          
          return  result;
      }
    
    public List<Veiculo> listaVeic(int id)
      {
          
          String sql = "SELECT * FROM cadveiculo where idprop_veic = ? ";
          PreparedStatement pst = Conexao.getPreparedStatement(sql);
          
          List<Veiculo> result = new ArrayList<>();

          try
          {
            pst.setInt(1, id);
            ResultSet rs = pst.executeQuery();
            while(rs.next())
           {
                Veiculo carro = new Veiculo();
                carro.setIdveic(rs.getInt("id_veic"));
                carro.setPlaca(rs.getString("placa_veic"));
                carro.setModelo(rs.getString("modelo_veic"));
                carro.setMarca(rs.getString("marca_veic"));
                carro.setCor(rs.getString("cor_veic"));
                carro.setImagem(rs.getBytes("imagem_veic"));
                
                result.add(carro);
                
            }
            
            
              
          } catch (Exception e) {
          }
          
          return  result;
      }
    
}
