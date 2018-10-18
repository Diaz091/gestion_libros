package models;

public class Libro {

	private String codigoB;
	private String isbn;
	private String titulo;
	private String autor;
	private String editorial;
	private String asig;
	private EstadoLibro estado;
	
		
	public Libro(String codigoB, String isbn, String titulo, String autor, String editorial, String asig, EstadoLibro estado) {
			
		this.codigoB = codigoB;
		this.isbn = isbn;
		this.titulo = titulo;
		this.autor = autor;
		this.editorial = editorial;
		this.asig = asig;
		this.estado = estado;
	}
	
	
	
	@Override
	public String toString() {
		return "Libro [codigoB=" + codigoB + ", isbn=" + isbn + ", titulo=" + titulo + ", autor=" + autor
				+ ", editorial=" + editorial + ", asig=" + asig + ", estado=" + estado + "]";
	}



	// GETTERS \\
	public String getCodigoB() {
		return codigoB;
	}
	public String getIsbn() {
		return isbn;
	}
	public String getTitulo() {
		return titulo;
	}
	public String getAutor() {
		return autor;
	}
	public String getEditorial() {
		return editorial;
	}
	public String getAsig() {
		return asig;
	}
	public EstadoLibro getEstado() {
		return estado;
	}
	
	
	
	
	
	
	
}
