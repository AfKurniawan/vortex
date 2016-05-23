<?php
class Genre_model extends MY_Model{

	protected $_table_name = 'genres';
	protected $_order_by = 'genre';

	protected $has_many = array(
		'artist_genres'=>array('primary_key'=>'artist_id','model'=>'artist_genre_model')
			));
	
	function __construct (){
			parent::__construct();
			$this->_database = $this->db;
	}
}