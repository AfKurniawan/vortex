<?php
class Venue extends CI_Controller
{

	public function __construct ()
	{
		parent::__construct();
		$this->load->model('venue_model');
	}

}