<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>  
      
<!DOCTYPE html>
<html lang="pt-br"> 
  <head>
    <!-- Meta tags Obrigatórias -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">

    <title>Cadastro de Produto</title>
  </head>
  <body>
  
  <div class="container">
  
    <form action="novoproduto">
    
  <div class="form-group">
    <label for="idproduto">Código do Produto</label>
    <input type="text" class="form-control" name="idproduto">
  </div>
  
  <div class="form-group">
    <label for="nome">Nome</label>
    <input type="text" class="form-control" id="" placeholder="Digite Nome do Produto" name="nome">
  </div>
  
  <div class="form-group">
    <label for="preco">Preço</label>
    <input type="text" class="form-control" id="" placeholder="Digite o Preço do Produto" name="preco">
  </div>
  
    <div class="form-group">
    <label for="quantidade">Quantidade</label>
    <input type="text" class="form-control" id="" placeholder="Digite a quantidade do Produto" name="quantidade">
  </div>
  
  <button type="submit" class="btn btn-primary">Enviar</button>
</form>
 </div>
    <!-- JavaScript (Opcional) -->
    <!-- jQuery primeiro, depois Popper.js, depois Bootstrap JS -->
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
  </body>
</html>