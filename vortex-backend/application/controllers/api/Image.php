<?php
class Image extends CI_Controller
{

	public function __construct ()
	{
		parent::__construct();
		$this->load->model('image_model');
	}

}