package pilha;

public class Pilha<Item>{
    private Node<Item> topo;
    private int n;

    private static class Node<Item> {
        private Item item;
        private Node<Item> next;
    }



    public void empilha(Item item) {
        Node<Item> antigo = topo;
        topo = new Node<Item>();
        topo.item = item;
        topo.next = antigo;
        n++;
    }

    public Item desempilha() {
        Item item = topo.item;
        topo = topo.next;
        n--;
        return item;  
    }
    
    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        Node tempNode = null;
        result.append("[");
       
        if (topo != null) {
            for(tempNode = topo; tempNode != null; tempNode = tempNode.next) {
                if (tempNode.next == null){
                   result.append(tempNode.item + ""); 
                } else
                result.append(tempNode.item + ", ");
            }
        }

        result.append("]");
       
        return result.toString();
    }
       
}

