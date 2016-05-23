<?php


$email = $_POST['email'];
$password = $_POST['password'];
 
require_once('dbConnect.php');

$sql = "select * from users where email='$email' and password='$password'";
 
$res = mysqli_query($con,$sql);
 
$check = mysqli_fetch_array($res);
 
if(isset($check)){
	$data = array('name' => $check[name],'email'=>$check[email]);
echo json_encode($data);
}else{
echo 'failure';
}
 
mysqli_close($con);
?>