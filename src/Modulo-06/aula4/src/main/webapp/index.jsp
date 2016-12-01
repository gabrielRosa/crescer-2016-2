<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <script src="http://code.jquery.com/jquery-2.1.4.js"
        type="text/javascript"></script>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
    </head>
    <body>
        <div style="width: 760px;
             padding: 14px 14px 0;">
            <form id="form-nome" class="form-horizontal" method="POST" >
                <div class="form-group">
                    <label for="nome" class="col-md-3">Nome</label>
                    <div class="col-md-9">
                        <input type="text" id="nomeInscricao" name="nome" class="form-control has-error" required />
                    </div>
                </div>

                <div class="form-group">
                    <div id="container-botao-entrar" class="col-md-3">
                        <button type="submit" class="btn btn-primary">Inscrição</button>
                    </div>
                </div>
            </form>
        </div>
        <div id="lista"></div>
        <script>
            this.$formInscricao = $('#form-nome');
            let form = this.$formInscricao(function (nome) {
                $.ajax({
                    url: 'post/' + nome,
                    type: 'POST'
                })
                        .then(function (resultado) {
                            $('#lista').html(resultado);
                        })
                        .fail(function (erro) {
                            console.error(erro);
                        });
            });
        </script>
    </body>
</html>
