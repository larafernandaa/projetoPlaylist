package projetoPlaylist;

public class Musica {
	String titulo;
	String artista;
	int codigo;
	int duracao;
	boolean favorita;
	
	Musica (String titulo, String artista, int codigo, int duracao){
		this.titulo = titulo;
		this.artista = artista;
		this.codigo = codigo;
		this.duracao = duracao;
		this.favorita = false;
		
	}
	
	public String toString () {
		int minutos = duracao / 60;
        int segundos = duracao % 60;
		
		return  " [# " + codigo + " ] ️▶️ " + titulo + " - " + artista + "( " + minutos + ":" + segundos + " )";
	}
}

