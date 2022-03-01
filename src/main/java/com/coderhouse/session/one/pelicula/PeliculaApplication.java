package com.coderhouse.session.one.pelicula;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PeliculaApplication implements CommandLineRunner {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public static void main(String[] args) {
		SpringApplication.run(PeliculaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		String sql = "CREATE TABLE movie(id serial NOT NULL, title varchar NULL, category varchar NULL " +
				"actor varchar NOT NULL, CONSTRAINT movie_pkey PRIMARY KEY(id))";

		int rows = jdbcTemplate.update(sql);

		if (rows > 0) {
			System.out.println("Table Movie has been created");
		}

		//Llamada al metodo de insertar en tabla
		this.interInTable();

		//Llamada al metodo update
		this.updateTable();

		this.selectMovie();

		this.deleteMovie();
	}

	public void interInTable(){
		String insertSQL = "INSERT INTO movie(title, category, actor) values(?,?,?)";

		jdbcTemplate.execute(insertSQL, (PreparedStatementCallBack<Boolean>) ps -> {
			ps.setString(1, "Dr. Strange");
			ps.setString(2, "Science fiction");
			ps.setString(3, "Benedict");

			return ps.execute();
		});

		System.out.println("You have inserted a new register into movie table");
	}

	public void updateTable(){
		String updateSQL = "UPDATE movie set actor = 'Benedict Cumberbatch' where actor = 'Benedict'";

		jdbcTemplate.execute(updateSQL, (PreparedStatementCallBack<Boolean>) ps -> {
			return ps.execute();
		});

		System.out.println("You have updated the table movie");
	}

	public void selectMovie() {
		String selectSQL = "SELECT * FROM movie WHERE id = 1";

		jdbcTemplate.execute(selectSQL, (PreparedStatementCallBack<Boolean>) ps -> {
			return ps.execute();
		});

		System.out.println("movie selected");
	}

	public void deleteMovie(){
		String deleteSQL = "DELETE FROM movie WHERE id = 1";

		jdbcTemplate.execute(deleteSQL, (PreparedStatementCallBack<Boolean>) ps -> {
			return ps.execute();
		});

		System.out.println("movie eliminated");
	}


}
