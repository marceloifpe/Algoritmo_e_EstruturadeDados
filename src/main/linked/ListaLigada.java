package linked;

/* Marcelo Augusto de Barros Araújo atividade prática 03 testes completos */
import list.EstruturaElementar;

public class ListaLigada implements EstruturaElementar {

    private No cabeca;

    public ListaLigada() {
        cabeca = null;
    }

    @Override
    public boolean buscaElemento(int valor) {
        if (cabeca == null) {
            return false;
        }
        for (No atual = cabeca; atual != null; atual = atual.getProximo()) {
            if (atual.getValor() == valor) {
                return true;
            }
        }
        return false;
    }

    @Override
    public int buscaIndice(int valor) {
        if (cabeca == null) {
            return -1;
        }
        int pos = 0;
        for (No atual = cabeca; atual != null; atual = atual.getProximo()) {
            if (pos == valor) {
                return atual.getValor();
            }
            pos++;
        }
        return -1;
    }

    @Override
    public int minimo() {
        int min = cabeca.getValor();
        for (No atual = cabeca; atual != null; atual = atual.getProximo()) {
            if (atual.getValor() < min) {
                min = atual.getValor();
            }
        }
        return min;
    }

    @Override
    public int maximo() {
        int max = cabeca.getValor();
        for (No atual = cabeca; atual != null; atual = atual.getProximo()) {
            if (atual.getValor() > max) {
                max = atual.getValor();
            }
        }
        return max;
    }

    @Override
    public int predecessor(int valor) {
        if (valor > 0) {
            int pos = 1;
            No ant = null;

            for (No atual = cabeca; atual != null; atual = atual.getProximo()) {
                if (pos == valor) {
                    if (ant != null) {
                        return ant.getValor();
                    } else {
                        return -1;
                    }
                }
                ant = atual;
                pos++;
            }
            return -1;
        } else {
            return -1;
        }
    }

    @Override
    public int sucessor(int valor) {
        int pos = -1;
        for (No atual = cabeca; atual != null; atual = atual.getProximo()) {
            pos++;
            if (pos == valor) {
                if (atual.getProximo() != null) {
                    return atual.getProximo().getValor();
                } else {
                    return -1;
                }
            }
        }
        return -1;
    }

    @Override
    public void insereElemento(int valor) {
        No criado = new No(valor);
        if (cabeca == null) {
            cabeca = criado;
        } else {
            No atual = cabeca;
            cabeca = new No(valor);
            cabeca.setProximo(atual);
        }
    }

    @Override
    public void insereElementoPosicao(int valor, int buscaIndice) {
        No criado = new No(valor);
        if (cabeca == null) {
            cabeca = criado;
        } else {
            No atual = cabeca;
            int recebe_atual = 0;
            if (buscaIndice == 0) {
                criado.setProximo(cabeca);
                cabeca = criado;
            } else {
                while (atual.getProximo() != null) {
                    atual = atual.getProximo();
                    recebe_atual++;
                    if (recebe_atual == buscaIndice) {
                        criado.setProximo(atual);
                        atual.setProximo(criado);
                    }
                }
            }
        }
    }

    @Override
    public void insereInicio(int valor) {
        if (this.cabeca == null) {
            this.cabeca = new No(valor);
        } else {
            No n = new No(valor);
            n.setProximo(this.cabeca);
            this.cabeca = n;
        }
    }

    @Override
    public void insereFim(int valor) {
        No criado = new No(valor);
        if (cabeca == null) {
            cabeca = criado;
        } else {
            No cauda = cabeca;
            while (cauda.getProximo() != null) {
                cauda = cauda.getProximo();
            }

            cauda.setProximo(criado);
        }
    }

    @Override
    public void remove(int valor) {
        if (cabeca == null) {
            return;
        }
        if (cabeca.getValor() == valor) {
            cabeca = cabeca.getProximo();
        } else {
            No atual = cabeca;
            while (atual.getProximo() != null) {
                if (atual.getProximo().getValor() == valor) {
                    atual.setProximo(atual.getProximo().getProximo());
                    return;
                }
                atual = atual.getProximo();
            }
        }
    }

    @Override
    public void removeIndice(int indice) {
        if (cabeca == null) {
            return;
        }
        if (indice == 0) {
            cabeca = cabeca.getProximo();
        } else {
            No atual = cabeca;
            int posicao = 0;
            while (atual.getProximo() != null) {
                if (posicao == indice - 1) {
                    atual.setProximo(atual.getProximo().getProximo());
                    return;
                }
                atual = atual.getProximo();
                posicao += 1;
            }
        }
    }

    @Override
    public void removeInicio() {
        if (cabeca == null) {
            return;
        }

        cabeca = cabeca.getProximo();
    }

    @Override
    public void removeFim() {
        if (cabeca == null) {
            return;
        }
        No atual = cabeca;
        while (atual.getProximo() != null) {
            if (atual.getProximo().getProximo() == null) {
                atual.setProximo(null);
                return;
            }
            atual = atual.getProximo();
        }
    }

}
