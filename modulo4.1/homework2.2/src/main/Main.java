package main;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Accumulators;
import com.mongodb.client.model.Filters;
import org.bson.Document;
import org.bson.conversions.Bson;

import java.util.*;

import static com.mongodb.client.model.Aggregates.group;
import static com.mongodb.client.model.Aggregates.match;
import static com.mongodb.client.model.Filters.and;
import static com.mongodb.client.model.Filters.eq;
import static com.mongodb.client.model.Projections.include;
import static java.util.Arrays.asList;

public class Main {

    public static void main(String[] args) {

        String uri = "mongodb://root:root@localhost:27017/?authSource=admin&readPreference=primary&appname=MongoDB%20Compass&directConnection=true&ssl=false";
        MongoClient mongoClient = MongoClients.create(uri);

        MongoDatabase mongoDatabase = mongoClient.getDatabase("test");

        MongoCollection<Document> alunos = mongoDatabase.getCollection("alunos");
        MongoCollection<Document> comentarios = mongoDatabase.getCollection("comentarios");
        MongoCollection<Document> usuarios = mongoDatabase.getCollection("usuarios");

        // Novo aluno
//        Document novoAluno = new Document("nome", "Yasmim")
//                .append("_id", 3)
//                .append("data_nascimento", new Date(200, 05, 30))
//                .append("curso", new Document("nome", "Enfermagem"))
//                .append("notas", asList(7, 7, 8))
//                .append("habilidades", asList(new Document()
//                                .append("nome", "Ingles ")
//                                .append("nível", "Basico"),
//                        new Document()
//                                .append("nome", "Espanhol")
//                                .append("nível", "Básico")));
//
//        Document novoAluno2 = new Document("nome", "Eduardo")
//                .append("_id", 4)
//                .append("data_nascimento", new Date(1997, 06, 15))
//                .append("curso", new Document("nome", "Ciencia da computação"))
//                .append("notas", asList(8, 9, 4.5))
//                .append("habilidades", asList(new Document()
//                                .append("nome", "Ingles ")
//                                .append("nível", "Intermediario"),
//                        new Document()
//                                .append("nome", "Espanhol")
//                                .append("nível", "Básico")));
//
//        List<Document> alunosList = List.of(novoAluno,novoAluno2);
//        // insere mais alunos
//        alunos.insertMany(alunosList);


        // Insere novoAluno
        //alunos.insertOne(novoAluno);

        // Projeções
        System.out.println("\nProjeções de alguns campos do usuario");
        Bson filter = Filters.empty();
        Bson projectionUser = include("nome", "genero", "email", "enable");
        usuarios.find(filter).projection(projectionUser).forEach(System.out::println);

        System.out.println("\nProjeções só comentarios");
        Bson projectionPlaylist = include("comentario");
        comentarios.find(filter).projection(projectionPlaylist).forEach(System.out::println);

        //alunos.updateOne(Filters.eq("nome", "Rodrigo"), new Document("$set", new Document("data_nascimento" , new Date(2020-1900, 04, 11))));
        //alunos.updateOne(Filters.eq("nome", "Eduardo"), new Document("$set", new Document("notas" , asList(8,8,9))));
        //usuarios.updateOne(Filters.eq("nome", "Rodrigo"), new Document("$set", new Document("enable", true)));

        //alunos.deleteOne(Filters.eq("nome" , "Rodrigo"));
        //comentarios.deleteOne(Filters.eq("_id","1"));
        //alunos.deleteMany(new Document());

        // Busca aluno
        System.out.println("-- Aluno");
        Document aluno = alunos.find(new Document("nome" , "Rodrigo"))
                .first();
        System.out.println(aluno);
        //printar todos
        alunos.find(new Document()).forEach(System.out::println);
        Document aluno1 = alunos.find(and(eq("nome", "Yasmim"))).first();
        System.out.println(aluno1);
        System.out.println("Find com usuario");
        Document usuario = usuarios.find(new Document("nome" , "Rodrigo"))
                .first();
        System.out.println(usuario);

        // Agrega dados
        System.out.println("-- Cursos");
        alunos.aggregate(Arrays.asList(
                        match(Filters.empty()),
                        group("$curso.nome", Accumulators.sum("qtd", 1))))
                .forEach(doc -> System.out.println(doc.toJson()));

        alunos.aggregate(asList(
                        group("$habilidades.nível", Accumulators.sum("Básico", 1))))
                .forEach(doc -> System.out.println(doc.toJson()));

        alunos.aggregate(Arrays.asList(
                        match(Filters.eq("nome","Rodrigo")),
                        group("$curso.nome", Accumulators.sum("qtd", 1))))
                .forEach(doc -> System.out.println(doc.toJson()));

        //printar quantidade de usuarios
        usuarios.aggregate(
                Arrays.asList(
                        match(Filters.empty()),
                        group("$genero", Accumulators.sum("Quantidade", 1))

                )
        ).forEach(System.out::println);

        mongoClient.close();
    }
}
