package negocio;

import dados.Contato;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ListaTelefonica {

    private Map<Character, List<Contato>> contatos;

    public ListaTelefonica() {
        this.contatos = new HashMap<>();
    }

    public void adicionarContato(Contato contato) {
        char inicial = Character.toUpperCase(contato.getNome().charAt(0));

        List<Contato> lista = contatos.get(inicial);
        if (lista == null) {
            lista = new ArrayList<>();
            contatos.put(inicial, lista);
        }
        lista.add(contato);
    }

    public void removerContato(Contato contato) {
        char inicial = Character.toUpperCase(contato.getNome().charAt(0));
        List<Contato> lista = contatos.get(inicial);

        if (lista != null) {
            lista.remove(contato);
            if (lista.isEmpty()) {
                contatos.remove(inicial);
            }
        }
    }

    public List<Contato> buscarContatos(char letra) {
        char inicial = Character.toUpperCase(letra);
        List<Contato> lista = contatos.get(inicial);
        return lista != null ? lista : new ArrayList<>();
    }

    public Map<Character, List<Contato>> buscarContatos() {
        return contatos;
    }
}