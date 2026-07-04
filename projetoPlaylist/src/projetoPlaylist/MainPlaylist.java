package projetoPlaylist;
import java.util.Scanner;

public class MainPlaylist {
	
	static Scanner leitor = new Scanner (System.in);
	static Playlist minhaPlaylist;
	
	static String lerTexto (String mensagem) {
		System.out.println(mensagem);
		return leitor.nextLine();
	}
	
	static int lerNumero(String mensagem) {
		System.out.println (mensagem);
		int numero = leitor.nextInt();
		leitor.nextLine();
		return numero;
	}
	
	static void mostrarMenu() {
		System.out.println("\n");
		System.out.println("1 - Adicionar música");
		System.out.println("2 - Ver playlist completa");
		System.out.println("3 - Remover música por codigo");
		System.out.println("4 - Remover musica por artista");
		System.out.println("5 - Buscar musica por artista");
		System.out.println("6 - Favoritar música");
		System.out.println("7 - Exibir musicas favoritas");
		System.out.println("8 - Exibir tempo final de playlist");
		System.out.println("0 - Sair");
	}
	
	static void opcaoCadastrarMusica() {
		System.out.println("\n------ CADASTRANDO MUSICA ------");
		String titulo = lerTexto ("Nome da música: ");
		String artista = lerTexto ("Nome do artista: ");
		int duracao = lerNumero("Duracao (em segundos): ");
		Musica novaMusica = new Musica (titulo, artista, 0, duracao);

		if (minhaPlaylist.adicionarMusica(novaMusica)) {
			System.out.println("Musica cadastrada!");
		} else {
			System.out.println("Playlist cheia! Limite de " + minhaPlaylist.musicas.length + "musicas atingidas");
		}
	}
	
	static void opcaoRemoverMusicaPorCodigo() {
		System.out.println ("\n------- REMOVER DA PLAYLIST POR CODIGO -------");
		int codigo = lerNumero ("Qual musica deseja remover por codigo: ");
		if (minhaPlaylist.removerMusicaPorCodigo(codigo)) {
			System.out.println("Musica removida com sucesso!");
		} else {
			System.out.println("Musica não encontrada");
		}
	}
	
	static void opcaoRemoverPorTitulo () {
		System.out.println ("\n------- REMOVER DA PLAYLIST POR TITULO --------");
		String titulo = lerTexto ("Qual musica deseja remover por titulo: ");
		if (minhaPlaylist.removerMusicaPorTitulo(titulo)) {
			System.out.println("Musica removida com sucesso!");
		} else {
			System.out.println("Musica não encontrada");
		}
	}

	
	static void opcaoBuscarPorArtista() {
		System.out.println ("\n------- MUSICAS DE UM ARTISTA -------");
		String artista = lerTexto ("Qual é o artista: ");
		
		Musica[] musicasEncontradas = minhaPlaylist.buscarMusicaPorArtista(artista);
		
		if (musicasEncontradas.length > 0) {
			System.out.println ("Foram encontradas " + musicasEncontradas.length + "musica(s)");
			minhaPlaylist.imprimirMusicasEncontradas(musicasEncontradas);
		} else {
			System.out.println ("Nenhuma musica deste artista foi encontrada encontrada!");
		}
	}
	
	static void opcaoFavoritarMusica() {
		System.out.println("\n------- FAVORITAR MUSICA -------");
        String titulo = lerTexto("Nome da musica para favoritar: ");
        if (minhaPlaylist.favoritarMusicas(titulo)) {
            System.out.println("Musica favoritada com sucesso!");
        } else {
            System.out.println("Musica nao encontrada!");
        }
	}
	
	static void opcaoExibirMusicasFavoritas() {
        System.out.println("\n------- MUSICAS FAVORITAS -------");
        minhaPlaylist.exibirFavoritas();
    }
    
    static void opcaoExibirTempoFinalDaPlaylist() {
        System.out.println("\n------- TEMPO TOTAL -------");
        minhaPlaylist.exibirTempoTotal();
    }
    
	public static void main (String[] args) {
		int tamanho = lerNumero ("Qual tamanho da playlist deseja: ");
		String nomePlaylist = lerTexto ("Qual o nome da playlist: ");
		String nomeDescricao = lerTexto ("Qual será a descrição da sua playlist: ");
		minhaPlaylist = new Playlist (nomePlaylist, nomeDescricao, tamanho);
		
		int op;
		do {
			mostrarMenu();
			op = lerNumero ("Escolha uma opção: ");
			
			switch(op) {
			
				case 1:
					opcaoCadastrarMusica();
					break;
				case 2:
					minhaPlaylist.exibirPlaylist();
					break;
				case 3:
					opcaoRemoverMusicaPorCodigo();
					break;
				case 4:
					opcaoRemoverPorTitulo();
					break;
					
				case 5:
					opcaoBuscarPorArtista();
					break;
				case 6:
					opcaoFavoritarMusica();
					break;
				case 7: 
					opcaoExibirMusicasFavoritas();
					break;
				case 8:
					opcaoExibirTempoFinalDaPlaylist();
					break;
					
				case 0:
					System.out.println("Saindo da Playlist...");
					break;
				default:
					System.out.println("\nOpção inválida!");
			}
			
		} while (op != 0);
		
	}
}
