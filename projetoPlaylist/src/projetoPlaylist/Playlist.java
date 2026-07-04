package projetoPlaylist;
import java.util.Random;

public class Playlist {
	String nomePlaylist;
	String descricao;
	Musica[] musicas;
	Random sorteioDeCodigo = new Random();
	int quantidadeAtualDeMusicas;
	
	Playlist (String nomePlaylist, String descricao, int tamanhoMaximo){
		this.nomePlaylist = nomePlaylist;
		this.descricao = descricao;
		this.musicas = new Musica [tamanhoMaximo];
		this.quantidadeAtualDeMusicas = 0;
	}
	
	boolean adicionarMusica(Musica novaMusica) {
		if (quantidadeAtualDeMusicas < this.musicas.length) {
			novaMusica.codigo = sorteioDeCodigo.nextInt(900) + 100;
			this.musicas[quantidadeAtualDeMusicas] = novaMusica;
			this.quantidadeAtualDeMusicas++;
			System.out.println("Musica adicionada! Codigo: "+ novaMusica.codigo );
			return true;
		}
		return false;
	}
	
	boolean removerMusicaPorCodigo (int codigo) {
		for (int i = 0; i < quantidadeAtualDeMusicas; i++) {
			if (musicas[i].codigo == codigo) {
				for (int j = i; j < quantidadeAtualDeMusicas - 1; j++) {
					musicas[j] = musicas[j + 1];
				} 
				musicas[quantidadeAtualDeMusicas -1] = null;
				quantidadeAtualDeMusicas--;
				return true;
			}
		}
		return false;
	}
	
	boolean removerMusicaPorTitulo (String titulo) {
		for (int i = 0; i < quantidadeAtualDeMusicas; i++) {
			if (musicas[i].titulo.equalsIgnoreCase(titulo)) {
				for (int j = i; j < quantidadeAtualDeMusicas - 1; j++) {
					musicas[j] = musicas[j + 1];
				}
				musicas[quantidadeAtualDeMusicas -1] = null;
				quantidadeAtualDeMusicas--;
				return true;
			}
		}
		return false;
	}
	
	Musica[] buscarMusicaPorArtista(String artista) {
		Musica[] musicasEncontradas = new Musica [quantidadeAtualDeMusicas];
		int contador = 0;
		for (int i = 0; i < quantidadeAtualDeMusicas; i++) {
			if (musicas[i].artista.equalsIgnoreCase(artista)) {
				musicasEncontradas[contador] = musicas[i];
				contador++;
			}
		}
		Musica[]resultadoFinaldasEncontradas = new Musica [contador];
		for (int i = 0; i < contador; i++) {
			resultadoFinaldasEncontradas[i] = musicasEncontradas[i];
		}
		return resultadoFinaldasEncontradas;
	}
	
	void imprimirMusicasEncontradas(Musica[] encontradas) {
		for (int i = 0; i < encontradas.length; i++) {
			System.out.printf("%d.%s\n", i + 1, encontradas[i]);
		}
	}
	
	void exibirTempoTotal () {
		int totalSegundos = 0;
		for (int i = 0; i < quantidadeAtualDeMusicas; i++) {
			totalSegundos += musicas[i].duracao;
		}
		int minutos = totalSegundos / 60;
		int segundos = totalSegundos % 60;
		System.out.println("Tempo total da playlist: ["+ minutos +":" + segundos +"]");
	}
	
	boolean favoritarMusicas (String nomeMusica) {
		for (int i = 0; i < quantidadeAtualDeMusicas; i++) {
			if (musicas[i].titulo.equalsIgnoreCase(nomeMusica)) {
				musicas[i].favorita = true;
				return true;
			}
		}
		return false;
	}
	
	void exibirFavoritas () {
		boolean temFavorita = false;
		for (int i = 0; i < quantidadeAtualDeMusicas; i++) {
			if (musicas[i].favorita == true) {
				System.out.println(musicas[i].toString());
				temFavorita = true;
			}
		}
		if (temFavorita == false) {
			System.out.println("Nenhuma musica favoritada");
		}	
	}
	
	void exibirPlaylist() {
		System.out.println("\n=================================");
		System.out.println("\n======= PLAYLYST: " + this.nomePlaylist + " =======");
		System.out.println (this.descricao);
		System.out.println("---------------------------------");
		
		if (quantidadeAtualDeMusicas == 0) {
			System.out.println("A playlist está vazia!");
		} else {
			for (int i = 0; i < quantidadeAtualDeMusicas; i++) {
				if (musicas[i] != null) {
					System.out.printf("%02d. %s\n", i + 1, musicas[i]);	
				}
			}
		}
		System.out.println("=================================");
	}
	
}
