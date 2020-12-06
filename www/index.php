<html>
 <head>
   <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">

    <title>Hello, world!</title></head>
 <body>
	<img src="pizza.jpg" style="width: 500px; margin: 0 auto; display: block;" >
 
	<div style="display: flex; justify-content: center; margin-top: 100px;">
	<?php
	
	function getPizza(){
		$queryUrl = 'http://localhost:8081/pizza';
		
		$curl = curl_init();
		curl_setopt_array($curl, array(
			CURLOPT_SSL_VERIFYPEER => 0,
			CURLOPT_POST => 0,
			CURLOPT_HEADER => 0,
			CURLOPT_RETURNTRANSFER => 1,
			CURLOPT_URL => $queryUrl
		));
		$result = curl_exec($curl);
		curl_close($curl);
		
		$result = json_decode($result, 1);
		
		if (array_key_exists('error', $result)) echo "Ошибка: ".$result['error_description']."<br>";
		return $result;
	
	}
	
	$pizzas = getPizza();
	
	foreach($pizzas as $pizza){?>
	
	<div class="card" style="width: 18rem;">
	  <div class="card-body">
		<h5 class="card-title"><?php echo $pizza["title"] ?></h5>
		<p class="card-text"><?php echo $pizza["price"] ?></p>
		<a href="pizza.php?id=<?php echo $pizza["pizzaId"] ?>" class="btn btn-primary">Click to details</a>
	  </div>
	</div>
	
	<?php		
	}
	
	?>
	
	</div>
	
  
 </body> 
</html>





