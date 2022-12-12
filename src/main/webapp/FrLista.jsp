<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    
   <%@page import = "Model.Cliente" %>
   <%@page import = "java.util.ArrayList" %>
   
   
   <%

    ArrayList<Cliente> lista = (ArrayList<Cliente>) request.getAttribute("clientes");


	%>
   

    
    <!DOCTYPE html>
<html lang="pt-br">
  <head>
    <!-- Meta tags Obrigatórias -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" >

    <title>Clientes</title>
  </head>
  <body>
  
  
   
<table class="table table-dark">
  <thead>
    <tr>
      
      <th scope="col">Código</th>
      <th scope="col">Nome</th>
      <th scope="col">Telefone</th>
    </tr>
  </thead>
  <tbody>
  
  <% for(int i=0;i<lista.size();i++){
  
  %>  
       
    <tr>
     
      <td><%=lista.get(i).getIdCliente()%></td>
      <td><%=lista.get(i).getNome()%></td>
      <td><%=lista.get(i).getTelefone()%></td>
      <td><a href="selecionado?idcliente=<%=lista.get(i).getIdCliente()%>"><button type="button" class="btn btn-primary">Editar</button></a></td>
      <td><a href="excluir?idcliente=<%=lista.get(i).getIdCliente()%>"><button type="button" class="btn btn-primary">Excluir</button></a></td>
    </tr>
   
    <%} %>
    
  </tbody>
</table>









    <!-- JavaScript (Opcional) -->
    <!-- jQuery primeiro, depois Popper.js, depois Bootstrap JS -->
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" ></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" ></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" ></script>
  </body>
</html>