<?php

if($_SERVER['REQUEST_METHOD']=='POST'){
 $name = $_POST['name'];
 $role = $_POST['role'];
 $password = $_POST['password'];
 $email = $_POST['email'];
 
 if($name == '' || $role == '' || $password == '' || $email == ''){
 echo 'please fill all values';
 }else{
 require_once('dbConnect.php');
 $sql = "SELECT * FROM users WHERE email='$email'";
 
 $check = mysqli_fetch_array(mysqli_query($con,$sql));
 
 if(isset($check)){
 echo 'Email already exist';
 }else{ 
 $sql = "INSERT INTO users (name,role,password,email) VALUES('$name','$role','$password','$email')";
 if(mysqli_query($con,$sql)){
 echo 'Successfully registered';
 }else{
 echo 'oops! Please try again!';
 }
 }
 mysqli_close($con);
 }
}else{
echo 'error';
}