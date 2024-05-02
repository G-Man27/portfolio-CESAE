package Jogo;

import Classes.Entidades.*;
import Classes.Items.Arma;
import Classes.Items.ConsumivelCombate;
import Classes.Items.ItemHeroi;
import Classes.Items.Pocao;
import Enums.Enimigos_classe;
import Enums.HeroisPermitidos;
import Enums.Sala;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Jogo {

    private static Heroi CriarPersonagem(HeroisPermitidos job, int pontos) {
        Scanner input = new Scanner(System.in);
        Heroi heroi = null;
        int ouro;
        int forca;
        int hp;
        String nome;
        Arma inicial_cavaleiro = new Arma("espada básica", 0, 10, 15);
        inicial_cavaleiro.addHeroi(HeroisPermitidos.CAVALEIRO);
        Arma inicial_feiticeiro = new Arma("varinha mágica básica", 0, 10, 15);
        inicial_feiticeiro.addHeroi(HeroisPermitidos.FEITICEIRO);
        Arma inicial_arqueiro = new Arma("arco básico", 0, 10, 15);
        inicial_arqueiro.addHeroi(HeroisPermitidos.ARQUEIRO);
        if (pontos == 300) {
            ouro = 20;
        } else {
            ouro = 15;
        }

        System.out.println("Tens " + pontos + " pontos de criação.");
        System.out.println("Cada ponto de vida vale um ponto de criação de personagem e cada ponto de força vale 5 pontos de criação de personagem.\nDistribui os pontos corretamente de modo a ficar com 0 pontos de criação da personagem.");
        do {
            System.out.print("Introduz o nº de pontos a alocar para a forca:");
            forca = input.nextInt();
            if (forca % 5 != 0) {
                System.out.println("Tens de indroduzir um nº multiplo de 5.");
            }
            if (forca > pontos) {
                System.out.println("Não tens assim tantos pontos.");
            }
            if (forca == pontos) {
                System.out.println("Tens de ter pelo menos um ponto a alocar para a vida.");
            }
        } while ((forca % 5 != 0) || forca >= pontos);
        pontos -= forca;
        hp = pontos;
        pontos -= hp;
        System.out.println("Foram alocados " + hp + " para a vida");

        System.out.print("Intoduz o nome que queres dar à tua personagem: ");
        input.nextLine();
        nome = input.nextLine();

        switch (job) {
            case CAVALEIRO -> {
                nome="Cavaleiro " + nome;
                heroi = new Cavaleiro(nome, hp, forca, ouro, inicial_cavaleiro);
            }
            case FEITICEIRO -> {
                nome="Feiticeiro " + nome;
                heroi = new Feiticeiro(nome, hp, forca, ouro, inicial_feiticeiro);
            }
            case ARQUEIRO -> {
                nome="Arqueiro " + nome;
                heroi = new Arqueiro(nome, hp, forca, ouro, inicial_arqueiro);
            }
        }

        return heroi;
    }


    /**
     * Jogo Aventura Mágica
     */
    public static void aventuraMagica() {
        boolean jogar = true;
        boolean vivo = false;
        boolean personagem_criada = false;
        Scanner input = new Scanner(System.in);
        HeroisPermitidos job = null;
        Heroi heroi = null;
        int n_sala =0;
        ArrayList<ItemHeroi> montra;
        int irnd = -1;

        //instanciar
        NPC goblin=new NPC("Goblin",10,8,10, Enimigos_classe.NORMAL);
        NPC kobolt=new NPC("Kobolt",12,13,20, Enimigos_classe.NORMAL);
        NPC wolf=new NPC("Wolf",10,15,25, Enimigos_classe.NORMAL);
        NPC small_golem=new NPC("Small Golem",20,11,25, Enimigos_classe.NORMAL);

        NPC big_golem=new NPC("Big Golem",50,20,55, Enimigos_classe.MID_BOSS);
        NPC treant=new NPC("Treant",40,25,60, Enimigos_classe.MID_BOSS);

        NPC dragon=new NPC("Dragon",100,35,120, Enimigos_classe.BOSS);
        NPC fenix=new NPC("Fenix",150,30,120, Enimigos_classe.BOSS);

        Pocao pocao_hp_10=new Pocao("Poção de vida 10",10,10,0);
        Pocao pocao_hp_20=new Pocao("Poção de vida 20",15,20,0);
        Pocao pocao_hp_50=new Pocao("Poção de vida 50",20,50,0);
        Pocao pocao_hp_full=new Pocao("Lágrimas da Fénix",100,10000000,0);

        Pocao pocao_forca_10=new Pocao("Poção de força 10",15,0,10);
        Pocao pocao_forca_15=new Pocao("Poção de força 15",20,0,15);
        Pocao pocao_forca_20=new Pocao("Poção de força 20",25,0,20);
        Pocao pocao_forca_25=new Pocao("Poção de força 25",35,0,25);

        Pocao pocao_mista_10_5=new Pocao("Poção de mista(hp+10/força+5)",25,10,5);
        Pocao pocao_mista_15_10=new Pocao("Poção de mista(hp+15/força+10)",30,15,10);
        Pocao pocao_mista_5_15=new Pocao("Poção de mista(hp+5/força+15)",30,5,15);
        Pocao pocao_mista_20_50=new Pocao("Poção de mista(hp+20/força+50)",77,20,50);

        Arma espada_magica=new Arma("Espada Mágica",90,50,70);
        espada_magica.addHeroi(HeroisPermitidos.CAVALEIRO);
        Arma cajado_magico=new Arma("Cajado Mágico",90,50,70);
        cajado_magico.addHeroi(HeroisPermitidos.FEITICEIRO);
        Arma arco_magico=new Arma("Arco Mágico",90,50,70);
        arco_magico.addHeroi(HeroisPermitidos.FEITICEIRO);
        Arma adaga_magica=new Arma("Adaga Mágica",150,60,120);
        adaga_magica.addHeroi(HeroisPermitidos.CAVALEIRO);
        adaga_magica.addHeroi(HeroisPermitidos.FEITICEIRO);
        adaga_magica.addHeroi(HeroisPermitidos.ARQUEIRO);

        ConsumivelCombate pocao_fogo=new ConsumivelCombate("Poção de fogo",65,85);
        pocao_fogo.addHeroi(HeroisPermitidos.FEITICEIRO);
        pocao_fogo.addHeroi(HeroisPermitidos.ARQUEIRO);
        pocao_fogo.addHeroi(HeroisPermitidos.FEITICEIRO);
        ConsumivelCombate pocao_gelo=new ConsumivelCombate("Poção de gelo",65,85);
        pocao_gelo.addHeroi(HeroisPermitidos.CAVALEIRO);
        pocao_gelo.addHeroi(HeroisPermitidos.FEITICEIRO);
        ConsumivelCombate pocao_relampago=new ConsumivelCombate("Poção de relampago",65,85);
        pocao_relampago.addHeroi(HeroisPermitidos.FEITICEIRO);
        pocao_relampago.addHeroi(HeroisPermitidos.ARQUEIRO);



        //Iniciar jogo
        System.out.println("Game Start!");
        do {
            System.out.println("New Game");
            n_sala =1;

            //Escoller o job da Personagem/Heroi
            do {
                System.out.println("Escolhe o teu job:");
                System.out.println("1. Cavaleiro");
                System.out.println("2. Feiticeiro");
                System.out.println("3. Arqueiro");
                System.out.print("Introduz o número da tua escolha: ");
                switch (input.nextInt()) {
                    case 1 -> {
                        job = HeroisPermitidos.CAVALEIRO;
                        personagem_criada = true;
                    }
                    case 2 -> {
                        job = HeroisPermitidos.FEITICEIRO;
                        personagem_criada = true;
                    }
                    case 3 -> {
                        job = HeroisPermitidos.ARQUEIRO;
                        personagem_criada = true;
                    }
                    default -> {
                        System.out.println("Opção inválida.");
                        personagem_criada = false;
                    }

                }
            } while (!personagem_criada);
            personagem_criada = false;

            //Escollher a dificuldade
            do {
                System.out.println("Escolhe a dificuldade:");
                System.out.println("1. Fácil");
                System.out.println("2. Difícil");
                System.out.print("Introduz o número da tua escolha: ");
                switch (input.nextInt()) {
                    case 1 -> {
                        heroi = CriarPersonagem(job, 300);
                        personagem_criada = true;
                        vivo = true;
                    }
                    case 2 -> {
                        heroi = CriarPersonagem(job, 220);
                        personagem_criada = true;
                        vivo = true;
                    }
                    default -> {
                        System.out.println("Opção inválida.");
                        personagem_criada = false;
                    }

                }
            } while (!personagem_criada);

            do {
                switch (n_sala) {
                    case 1:
                        heroi.mostrarDetalhes();
                        System.out.println("Acordaste numa estalagem e ao sair... ");
                        System.out.println("Deparaste com o Vendedor");
                        vivo = Sala.LOJA.entrar(heroi);
                        if (vivo) {
                            do {
                                System.out.println("Sai da loja e da aldeia e depara-se com um sinal com duas setas:");
                                System.out.println("1. Esquerda: Floresta");
                                System.out.println("2. Direita: Montanha");
                                System.out.print("Em que direção quer seguir? (Insira o número da direção): ");
                                switch (input.nextInt()) {
                                    case 1 -> n_sala = 2;
                                    case 2 -> n_sala = 7;
                                    default -> System.out.println("Opção inválida");
                                }
                            } while (n_sala == 1);
                        }
                        break;

                    case 2:
                        System.out.println("Ouve um barulho na floresta e de entre os arbustos aparecem inimigos.\nA luta começa.");
                        vivo = Sala.ENCONTRO.entrar(heroi);
                        if (vivo) {
                            System.out.println();
                            do {
                                System.out.println("Após vencer, continua a jornada e vê a distância uma cabana.\nQuer entrar na cabana?");
                                System.out.println("1. Sim");
                                System.out.println("2. Não");
                                System.out.print("Escolha uma opção: ");
                                switch (input.nextInt()) {
                                    case 1 -> n_sala = 3;
                                    case 2 -> n_sala = 4;
                                    default -> System.out.println("Opção inválida");
                                }
                            } while (n_sala == 2);
                        }
                        break;

                    case 3:
                        System.out.println("Abre a porta da cabana");
                        irnd = new Random().ints(1, 4, Sala.index.length).findAny().getAsInt();
                        vivo = Sala.index[irnd].entrar(heroi);
                        if (vivo) {
                            System.out.println();
                            System.out.println("Sai da cabana");
                            n_sala = 4;
                        }
                        break;

                    case 4:
                        System.out.println("Ao continuar a sua jornada pela floresta fazem lhe uma emboscada.");
                        vivo = Sala.ENCONTRO.entrar(heroi);
                        if (vivo) {
                            System.out.println("Vence a luta. Conseguiu sobreviver.\n" + "Anda mais um pouco. Chega a árvore da vida e encontra uma surpresa.");
                            irnd = new Random().ints(1, 4, 6).findAny().getAsInt();
                            vivo = Sala.index[irnd].entrar(heroi);
                        }
                        if (vivo) {
                            do {
                                System.out.println("Vê 2 caminhos:\n" +
                                        "1.\tPelo interior da árvore\n" +
                                        "2.\tÀ volta de árvore.");
                                System.out.print("Escolha uma opção: ");
                                switch (input.nextInt()) {
                                    case 1 -> n_sala = 5;
                                    case 2 -> n_sala = 6;
                                    default -> System.out.println("Opção inválida");
                                }
                            } while (n_sala == 4);
                        }
                        break;

                    case 5:
                        System.out.println("Ao subir pelo interior da árvore encontra um espaço aberto. De entre as sombras surge um vulto.");
                        irnd = new Random().ints(1, 1, 3).findAny().getAsInt();
                        vivo = Sala.index[irnd].entrar(heroi);
                        if (vivo) {
                            System.out.println("Vence a luta.De repente surge uma luz.");
                            vivo = Sala.TOTEM.entrar(heroi);
                        }
                        if (vivo) {
                            n_sala = 6;
                        }
                        break;

                    case 6:
                        System.out.println("Firmemente sobe através dos ramos chegando ao topo da magnífica e imponente árvore. \n" +
                                "Depara-se com o poderoso guardião da árvore da vida. A luta final começa!\n");
                        vivo = Sala.ENCONTRO_BOSS.entrar(heroi);
                        if (vivo) {
                            System.out.println("Parabéns! Conseguiu derrotar o guardião.\nA sua história será levada pelos sete  ventos a todos aqueles que sonham…");
                            n_sala = 14;
                        }
                        break;

                    case 7:
                        System.out.println("Chegou à base da montanha.\n" +
                                "É a montanha de Sísifo.\n" +
                                "De uma gruta aparecem inimigos.\n");
                        vivo = Sala.ENCONTRO.entrar(heroi);
                        if (vivo) {
                            do {
                                System.out.println("Vence-os e depara-se com 2 caminhos.\n" +
                                        "Um caminho mais íngreme e traiçoeiro e outro mais plano e regular, parecendo mais seguro.\n" +
                                        "Qual quer seguir?\n");
                                System.out.println("1.\tÍngreme\n" +
                                        "2.\tRegular");
                                System.out.print("Escolha uma opção: ");
                                switch (input.nextInt()) {
                                    case 1 -> n_sala = 8;
                                    case 2 -> n_sala = 9;
                                    default -> System.out.println("Opção inválida");
                                }
                            } while (n_sala == 7);
                        }
                        break;

                    case 8:
                        System.out.println("Prosseguiu pelo caminho irregular\n" +
                                "Debaixo dos seus pés começa a sentir um tremor.\n" +
                                "Olhando para cima, apercebe-se que é uma derrocada.\n");
                        vivo = Sala.ARMADILHA.entrar(heroi);
                        if (vivo) {
                            do {
                                System.out.println("Sobreviveu à armadilha, no entanto não sabe se deve continuar por este caminho.\n" +
                                        "À distância havia uma cabana, é possível que consiga encontrar algumas previsões.\n");
                                System.out.println("Quer:\n" +
                                        "1.\tum continuar pelo caminho.\n" +
                                        "2.\tDirigir-se à cabana");
                                System.out.print("Escolha uma opção: ");
                                switch (input.nextInt()) {
                                    case 1 -> n_sala = 10;
                                    case 2 -> n_sala = 3;
                                    default -> System.out.println("Opção inválida");
                                }
                            } while (n_sala == 8);
                        }
                        break;
                    case 9:
                        System.out.println("A vista pelo caminho da montanha é de tirar o folgo.\nAo virar da esquina encontra um Vendedor.");
                        vivo = Sala.LOJA.entrar(heroi);
                        System.out.println("Despedindo-se do vendedor continua a sua jornada");
                        n_sala = 10;
                        break;
                    case 10:
                        System.out.println("Continuando pela montanha, vê uma estrutura um pouco estranha.");
                        vivo = Sala.TOTEM.entrar(heroi);
                        if (vivo) {
                            System.out.println("Continua o seu caminho, mas não sabe o que poderá encontrar.");
                        }
                        vivo = Sala.TESOURO.entrar(heroi);
                        if (vivo) {
                            do {
                                System.out.println("Ainda de boa saúde, mas já exausto, encontra uma caverna que o poderá levar ao topo da montanha.");
                                System.out.println("Quer:\n" +
                                        "1.\tEntrar na caverna.\n" +
                                        "2.\tSeguir caminho.");
                                System.out.print("Escolha uma opção: ");
                                switch (input.nextInt()) {
                                    case 1 -> n_sala = 11;
                                    case 2 -> n_sala = 12;
                                    default -> System.out.println("Opção inválida");
                                }
                            } while (n_sala == 10);
                        }
                        break;

                    case 11:
                        System.out.println("Dentro da caverna, surge um grande espaço aberto.\n" +
                                "Sente uma presença e o chão treme.\nÉ um poderoso inimigo.\n");
                        vivo = Sala.ENCONTRO_MID.entrar(heroi);
                        if (vivo) {
                            System.out.println("Com muito esforço consegue sobreviver, mas ainda não chegou ao fim da sua jornada! Terá de continuar até ao topo!");
                            n_sala = 13;
                        }
                        break;

                    case 12:
                        System.out.println("O caminho pelo exterior da montanha é longo e depara-se com alguns inimigos.");
                        vivo = Sala.ENCONTRO.entrar(heroi);
                        if (vivo) {
                            System.out.println("Saindo vitorioso continua a sua jornada e encontra novamente aquela estrutura peculiar.");
                            vivo = Sala.TOTEM.entrar(heroi);
                        }
                        if (vivo) {
                            System.out.println("Neste momento, já tem o grandioso topo da montanha à vista!");
                            n_sala = 13;
                        }
                        break;

                    case 13:
                        System.out.println("Chegou ao topo da montanha. Os céus escurecem! Relâmpagos caem do céu. Mas de entre os barulhos poderosos dos trovões ouve algo ainda mais estridente.\n" +
                                "A sua alma começa a tremer. Uma imponente e aterradora figura aparece diante dos seus olhos. É o guardião da montanha. A luta não será fácil!\n");
                        vivo = Sala.ENCONTRO_BOSS.entrar(heroi);
                        if (vivo) {
                            System.out.println("Conseguiu vencer. Os seus feitos ecoarão pelos quatro cantos do mundo e a sua história transformar-se-á em lenda…");
                            n_sala = 14;
                        }
                        break;
                }
            } while (n_sala != 14 && vivo);

            if (vivo) {
                System.out.println("Parabéns venceu o Jogo");
            } else {
                System.out.println("Perdeu o Jogo");
            }

            boolean jogarNovamente_escolha = false;
            do {
                System.out.println("Quer jogar outra vez:\n" +
                        "1.\tSim.\n" +
                        "2.\tNão.");
                System.out.print("Escolha uma opção: ");
                switch (input.nextInt()) {
                    case 1 -> {
                        jogarNovamente_escolha = true;
                        jogar = true;
                    }
                    case 2 -> {
                        jogarNovamente_escolha = true;
                        jogar = false;
                    }
                    default -> {
                        System.out.println("Opção inválida");
                        jogarNovamente_escolha = false;
                    }
                }
            } while (!jogarNovamente_escolha);


        } while (jogar);
        System.out.println("Game Over");
        System.out.println("End Game!");
    }


}
