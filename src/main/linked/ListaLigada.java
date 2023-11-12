package linked;

import java.util.NoSuchElementException;

import list.EstruturaElementar;

public class ListaLigada implements EstruturaElementar{

    private No cabeca;
    private No cauda;
    private int tamanho;
    private int posicao;

    public ListaLigada() {
        cabeca = null;
        cauda = null;
        tamanho = 0;
        posicao = 0;
    }

    @Override
    public boolean buscaElemento(int valor) {
      No atual = cabeca;
      while (atual != null) {
        if(atual.getValor()==valor){
            return true;
        }
        atual = atual.getProximo();
      }
      return false;
    }

    @Override
    public int buscaIndice(int valor) {
       No atual = cabeca;
       int indice = 0;
       while (atual != null) {
        if(atual.getValor()==valor){
            return indice;
        }
        atual = atual.getProximo();
        indice++;
      }
      return -1;
    }

    @Override
    public int minimo() {
        if (cabeca == null) {
            throw new IllegalStateException("A lista está vazia.");
        }
    
        int minimo = cabeca.getValor();
        No atual = cabeca;
        while (atual != null) {
            if (atual.getValor() < minimo) {
                minimo = atual.getValor();
            }
            atual = atual.getProximo();
        }
        return minimo;
    }

    

    @Override
    public int maximo() {
        if (tamanho == 0) {
            return Integer.MIN_VALUE;
        }
    
        No atual = cabeca;
        int maximo = atual.getValor();
    
        while (atual != null) {
            if (atual.getValor() > maximo) {
                maximo = atual.getValor();
            }
            atual = atual.getProximo();
        }
    
        return maximo;
    }


    @Override
    public int predecessor(int valor) {
        No atual = cabeca;
        while (atual != null) {
            if (atual.getProximo() != null && atual.getProximo().getValor() == valor) {
                return atual.getValor();
            }
            atual = atual.getProximo();
        }
        throw new IllegalArgumentException("O elemento " + valor + " não foi encontrado ou é o primeiro elemento.");
    }

    @Override
    public int sucessor(int valor) {
        No atual = cabeca;
        while (atual != null) {
            if (atual.getValor() == valor && atual.getProximo() != null) {
                return atual.getProximo().getValor();
            }
            atual = atual.getProximo();
        }
        throw new IllegalArgumentException("O elemento " + valor + " não foi encontrado ou é o último elemento.");
    }

    @Override
    public void insereElemento(int valor) {
        if (cabeca == null) {
            cabeca = new No(valor);
            cauda = cabeca;
        } else {
            No novoNo = new No(valor);
            cauda.setProximo(novoNo);
            cauda = novoNo;
        }
        tamanho++;
    }
     

    @Override
    public void insereElementoPosicao(int valor, int buscaIndice) {
        if (posicao < 0 || posicao > tamanho) {
            throw new IllegalArgumentException("Posição inválida.");
        }
    
        if (posicao == 0) {
            insereInicio(valor);
            return;
        }
    
        No atual = cabeca;
        for (int i = 1; i < posicao; i++) {
            atual = atual.getProximo();
        }
    
        No novo = new No(valor);
        novo.setProximo(atual.getProximo());
        atual.setProximo(novo);
        tamanho++;
    }
    
    
       
    @Override
    public void insereInicio(int valor) {
        if (this.cabeca == null){
            this.cabeca = new No(valor);
        }else{
            No n = new No(valor);
            n.setProximo(this.cabeca);
            this.cabeca = n;
        }
    }

    @Override
    public void insereFim(int valor) {
        if (cabeca == null) {
            cabeca = new No(valor);
            cauda = cabeca;
        } else {
            No novoNo = new No(valor);
            cauda.setProximo(novoNo);
            cauda = novoNo;
        }
    }
    

        
    

    @Override
    public void remove(int valor) {
        No atual = cabeca;
        No anterior = null;
    
        while (atual != null) {
            if (atual.getValor() == valor) {
                if (atual == cabeca) {
                    cabeca = atual.getProximo();
                } else {
                    anterior.setProximo(atual.getProximo());
                }
                tamanho--;
                return;
            }
    
            anterior = atual;
            atual = atual.getProximo();
        }
    
        throw new IllegalArgumentException("O elemento " + valor + " não foi encontrado na lista.");
    }

    @Override
    public void removeIndice(int indice) {
        if (indice < 0 || indice >= tamanho) {
            throw new IndexOutOfBoundsException("O índice " + indice + " é inválido.");
        }

        if (indice == 0) {
            if (cabeca != null) {
                cabeca = cabeca.getProximo();
            } else {
                throw new NoSuchElementException("A lista está vazia.");
            }
            tamanho--;
            return;
        }

        No atual = cabeca;
        No anterior = null;
        int i = 0;

        while (i < indice) {
            anterior = atual;
            atual = atual.getProximo();
            i++;
        }

        if (atual == cabeca) {
            cabeca = atual.getProximo();
        } else {
            anterior.setProximo(atual.getProximo());
        }

        tamanho--;
    }
    

    @Override
    public void removeInicio() {
        if (cabeca == null) {
            return;
        }
    
        cabeca = cabeca.getProximo();
        tamanho--;
    
        if (cabeca == null) {
            cauda = null;
        }
    }

    @Override
    public void removeFim() {
        if (cabeca == null) {
            return;
        }
    
        if (cabeca.getProximo() == null) {
            cabeca = null;
            cauda = null;
            tamanho--;
            return;
        }
    
        No atual = cabeca;
        while (atual.getProximo().getProximo() != null) {
            atual = atual.getProximo();
        }
    
        cauda = atual;
        atual.setProximo(null);
        tamanho--;
    }
    
}
