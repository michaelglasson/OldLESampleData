package net.mynym.lesampledata.processing;

import java.io.File;
import java.io.IOException;

import org.neo4j.graphdb.GraphDatabaseService;
import org.neo4j.graphdb.factory.GraphDatabaseFactory;

import net.mynym.lesampledata.entities.PersonRepo;

public class CreatePersons {
	public static void main(String[] args) throws IOException {
		PersonRepo repo = new PersonRepo();
		for (int i = 0; i < 1000; i++) {
			repo.addNewPerson();
		}
		repo.writeToFile();
		GraphDatabaseService db = new GraphDatabaseFactory()
				.newEmbeddedDatabase(new File("C:\\Users\\mg\\Documents\\neo4j\\data\\databases\\graph.db"));
		repo.graph(db);
	}

}
