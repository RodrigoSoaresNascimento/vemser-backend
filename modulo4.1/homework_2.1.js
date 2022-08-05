// Criando documento
db.createCollection("comentarios");

db.createCollection("usuarios");

// Inserindo um
db.comentarios.insertOne(
	{
		_id:1,
    	comentario: "músicas de são joão",
    	id_playlist : 1,
    	id_comentario : 1  
	}
);

db.usuarios.insertOne(
	{
		_id:1,
    	nome: "Rodrigo",
    	data_nascimento : new Date (1997,02,26),
		genero: "M",
		email: "rodrigo@gmail.com",
		login: "rodrigo",
		senha: "123",
		enable: true,
    	id_cargo : 3  
	}
);

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
		}
		
	]
);

// Inserindo vários
db.usuarios.insertMany(
	[
		{
			_id: 2,
			nome: "Cleber",
			data_nascimento : new Date ( 1994,05,08),
			genero: "M",
			email: "cleber@gmail.com",
			login: "cleber",
			senha: "123",
			enable: true,
			id_cargo : 1
			
		},
		{
			_id: 3,
			nome: "Bruno",
    		data_nascimento :new Date ( 1998,06,25),
			genero: "M",
			email: "bruno@gmail.com",
			login: "bruno",
			senha: "123",
			enable: true,
    		id_cargo : 2 
		}
		
	]
);


// busca todos os comentario
db.comentarios.find({});


// delete
db.comentarios.deleteOne({ _id: 3 });
db.comentarios.deleteMany({});
db.usuarios.deleteMany({});
//Find Equal
db.usuarios.find({
    nome: "Rodrigo"
});

//Find AND
db.comentario.find({
    comentario: "Melhores do  Alan Walker", 
    id_playlist: { $lt: 3 }
});

db.usuarios.find({
    nome: "Rodrigo", 
    id_cargo: { $lt: 4 }
});

//Find OR / IN

db.usuarios.find({
    $or : [
        {"login" : "rodrigo"},
        {"login" : "Bruno"},
        {"login" : "Cleber"}
    ],
    "nome" : "Rodrigo"
 });

//Find Expressão

db.usuarios.find({
    "nome": /^Ro/ 
});

db.comentarios.find({
    "comentario": /^Me/ 
});

//Update

db.usuarios.updateOne(
	{ nome: "Rodrigo" },
	{
	  $set: { "nome": "Rodrigo", enable: false }           
	}
 );

 db.comentarios.updateOne(
	{ _id: 1 },
	{
	  $set: { "comentario": "Musicas da paraiba" }           
	}
 );

//Find Ordenado

db.usuarios.find({
    data_nascimento : { $gte: new Date ( 1996,06,25) } 
}).sort("nome");

db.usuarios.find({ }).sort( { data_nascimento : 1, nome: -1 } );

//Find Limite

db.usuarios.find({ enable: true }).sort( { _id : -1 } ).limit(3);

db.comentarios.find( {id_playlist: {$gte:1} }).sort( { _id : -1 } ).limit(3);

db.createCollection("playlists");

db.playlists.insertMany([

	{
		_id: 1,
		nome: "Musicas antigas",
		musicas: [
			{
				_id: "4qvUtYRNwmFzfJ2loWkQCH",
				name: "Vilarejo",
				disc_number: 1,
				popularity: 61,
				preview_url: "https://p.scdn.co/mp3-preview/0fc3d6b4c2ef69733f85d2afa146644dfa3aee4e?cid=68e29005ed5d4c838871f76bd274f6b8"
			},
			{
				_id: "6A3Q8BVAAI2PW1s6MX4ZGF",
				name: "Boa Sorte / Good Luck (feat. Ben Harper)",
				disc_number: 1,
				popularity: 63,
				preview_url: "https://p.scdn.co/mp3-preview/ee7e2c41641384fd49a50112f8970c323f669ded?cid=68e29005ed5d4c838871f76bd274f6b8"
			}
		]
	},
	{
		_id: 2,
		nome: "Melhores Alan Walker",
		musicas: [
			{
				_id: "7gHs73wELdeycvS48JfIos",
				name: "Faded",
				disc_number: 1,
				popularity: 72,
				preview_url: "https://p.scdn.co/mp3-preview/e99128a990c88ad3788e8b0ab55b3d301d52e3c0?cid=68e29005ed5d4c838871f76bd274f6b8"
			},
			{
				_id: "6SRWhUJcD2YKahCwHavz3X",
				name: "Darkside",
				disc_number: 1,
				popularity: 74,
				preview_url: "https://p.scdn.co/mp3-preview/b5e08f76dc4dab3e678030570da21472990d761e?cid=68e29005ed5d4c838871f76bd274f6b8"
			},
			{
				_id: "4uDhts78RdwIDjEqPrYVKp",
				name: "Sweet Dreams",
				disc_number: 1,
				popularity: 76,
				preview_url: "https://p.scdn.co/mp3-preview/651e03cd93f6c22264149166ea5c7b40d4127f0f?cid=68e29005ed5d4c838871f76bd274f6b8"
			},
			{
				id: "0lks2Kt9veMOFEAPN0fsqN",
				name: "Lily",
				disc_number: 1,
				popularity: 74,
				preview_url: "https://p.scdn.co/mp3-preview/746da4d39c7ba70816c0d0ba8714f209871b0ec6?cid=68e29005ed5d4c838871f76bd274f6b8"
			},
			{
			id: "3LlmKSHR3Rs0Y3KHQLAYDk",
			name: "Alone",
			disc_number: 1,
			popularity: 74,
			preview_url: "https://p.scdn.co/mp3-preview/197b37df40fb444d4747d55de7efa84dc219ddd5?cid=68e29005ed5d4c838871f76bd274f6b8"
			}
		]
	},
	{
		_id: 3,
		nome: "Musicas para relaxar",
		musicas: []
	},
	{
		_id: 4,
		nome: "Musicas para malhar",
		musicas: []
	}
	
]);


// Contém
db.playlists.find(  {musicas :{$elemMatch:{ name :"Alone"} } } );

db.playlists.find(  {musicas :{$elemMatch:{ name :"Vilarejo"} } } );

// Condição múltipla, no mesmo elemento do array
db.playlists.find( { musicas: {$elemMatch:{ popularity :{ $gt: 70, $lt: 80 }} } } );

// Tamanho
db.playlists.find( { "musicas": { $size: 2 } } );


//Projections

db.playlists.find( {}, { _id: 2, nome: "Melhores Alan Walker", "musicas.name": 1 } );

db.usuarios.find({ enable: true}, 
{
 nome_idade: { $concat: [ "$nome", " - ", { $convert: { input: "$idade", to: "string" }}] },
 data_nascimento: { $dateToString: { date: "$data_nascimento", format: "%d/%m/%Y" } },
 nome: 1
});

//Aggregate

db.usuarios.aggregate( [
	{ $match: { enable: true } },
	{ $group: { _id: "$nome"} }
 ] );

 db.playlists.aggregate( [
	{ $match: { musicas: {$elemMatch : {popularity : {$gte : 74}}} } },
	{ $group: { _id: "$nome"} }
 ] );