<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    
    <!DOCTYPE html>
<html lang="pt-br">
  <head>
   
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">

    <title>Cadastro de Cliente</title>
  </head>
  <body>
  
  <div class="container">
  
  <form action="novocliente">
 
  <div class="form-group">
    <label for="idcliente">Código do Cliente</label>
    <input type="text" class="form-control" name="idcliente">   
  </div>
  
  <div class="form-group">
    <label for="nome">Nome</label>
    <input type="text" class="form-control" id="" placeholder="Digite Nome" name="nome">
  </div>
  
  <div class="form-group">
    <label for="telefone">Telefone</label>
    <input type="text" class="form-control" id="" placeholder="Digite Telefone" name="telefone">
  </div>
  
  <button type="submit" class="btn btn-primary">Enviar</button>
</form>

</div>
   
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" ></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
  </body>
</html>