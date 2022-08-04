// Criando documento
db.createCollection("comentarios");

// Inserindo um
db.comentarios.insertOne(
	{
		_id:1,
    	comentario: "músicas de são joão",
    	id_playlist : 1,
    	id_comentario : 1  
	}
);

// Inserindo vários
db.comentarios.insertMany(
	[
		{
			_id: 2,
			comentario: "Melhores do  Alan Walker",
			id_playlist: 2,
			id_usuario: 2
			
		},
		{
			_id: 3,
			nome: "Musicas para relaxar",
			id_playlist: 3,
			id_usuario: 3
		},
		{
			_id: 4,
			nome: "Musicas para malhar",
			id_playlist: 4,
			id_usuario: 4
		}
		
	]
);


// busca todos os comentario
db.comentarios.find({});


// Filtra por um id especifico
db.comentarios.find({ _id: 3 });

//Filtra onde o comentario é são joão ou id da playlist é 2
db.comentarios.find( { $or : [ {nome: "são joão"}, {id_comentario : {$lt:2}}]});

//filtra onde comentario é musicas e o id do usuario é maior que 1 ou começa com m
db.comentarios.find( {
	comentario: "musicas",
	$or: [ { id_usuario: { $lt: 1 } }, { comentario: /^m/ } ]
} );
