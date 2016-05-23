<?php
class Genre extends CI_Controller
{

	public function __construct ()
	{
		parent::__construct();
		$this->load->model('genre_model');
	}

}