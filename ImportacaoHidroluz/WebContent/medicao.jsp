<%@ page import="entity.*, persistence.*, java.util.*"%>
<!doctype html>
<html>

<head>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/jqueryui/1.12.0/jquery-ui.css" />
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" href="css/stylesistema.css">
<link rel="stylesheet" href="css/bootstrap.css">

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script type="text/javascript"
	src="https://code.jquery.com/ui/1.12.0/jquery-ui.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script type="text/javascript"
	src="https://cdnjs.cloudflare.com/ajax/libs/jquery-validate/1.16.0/jquery.validate.js"></script>
<script src="https://code.highcharts.com/highcharts.src.js"></script>
<script
	src='https://maps.googleapis.com/maps/api/js?key=AIzaSyBOGnYAV-oxy57rY3b2kggn5oHC-O64Jzg&callback=initMap'></script>

<link rel="shortcut icon" href="LogoOri.ico">
<title>Portal Hidroluz MediÃ§Ã£o</title>
</head>

<body>

	<!-- BARRA DE NAVEGAÃ�Ã�O -->
	<nav class="navbar navbar-fixed-top navbar-custom" id="mainNav">
		<div class="container-fluid">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle" data-toggle="collapse"
					data-target="#barra-collapse">
					<span class="sr-only">Barra NavegaÃ§Ã£o</span> Menu&nbsp; <i
						class="fa fa-bars"></i>
				</button>
				<a href="#" class="navbar-brand"><img src="img/logo-ntransp.png"
					class="imagemnav"></a>
			</div>
		</div>

		<div class="col-md-12"
			style="margin-left: 350px; margin-top: -100px; width: 600px;">
			<div class="row">

				<div class="col-md-6" style="text-align: left;">

					<input type="hidden" value="${unidade}${bloco}" id="unidade"
						readonly="readonly"> <a id="unidade" value="${unidade}"></a>
					<b>Condomínio: </b>${cond}<br> <b>Unidade: </b>${unidade}<br>
					<b>Bloco: </b>${bloco}

				</div>
			</div>
		</div>

		<div
			style="float: right; color: #fff; margin-right: 230px; margin-top: -100px">

			<a href="#" class="topo"><img height="36" width="36"
				src="${picture}" /><font size="3"><b>${nome}</b></font></a>
		</div>

		<div
			style="float: right; color: #fff; margin-right: 50px; margin-top: -65px">

			<a type="submit" class="btn btn-info"
				href="Controle?cmd=escolhaunidade"
				style="font-size: 11px; text-decoration: none; color: primary; margin-top: 10px;">Listar
				Unidades</a> <a type="submit" class="btn btn-info"
				href="Controle?cmd=alterar"
				style="font-size: 11px; text-decoration: none; color: primary; margin-top: 10px;">Editar
				Cadastro</a> <a type="submit" class="btn btn-info"
				href="Controle?cmd=sair"
				style="font-size: 11px; text-decoration: none; color: primary; margin-top: 10px;">Sair</a>

		</div>

	</nav>

	<!-- FECHA BARRA DE NAVEGAÇÃO -->

	<div class="grafico col-md-12" style="margin: 30px 0 30px 0">
		<div class="panel panel-info">
			<div class="panel panel-heading">
				<div class="panel-title">Data e hora</div>
			</div>
			<div class="panel-body">
				<div></div>
			</div>
		</div>
	</div>


</body>


</html>




