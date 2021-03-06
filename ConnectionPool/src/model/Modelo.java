/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import dao.AgendaBDDao;
import dao.Dao;
import java.util.ArrayList;

/**
 *
 * @author jose
 */
public class Modelo {

    private Agenda agenda;
    private AgendaBDDao agendaBd;

    private Dao dao;

    public Modelo() {
        this.agenda = new Agenda();
        this.agendaBd = new AgendaBDDao();

        this.dao = this.agendaBd;

    }

    ArrayList<Observer> observer = new ArrayList<>();

    public void attach(Observer observer) {

        this.observer.add(observer);
    }

    public void dettach(Observer observer) {
        this.observer.add(observer);

    }

    public void NotifyTtoAll() {
        for (Observer observer1 : this.observer) {
            observer1.update();
        }
    }

    public void resgistraContato(String nome, String email, String telefone) {

        this.agenda.setEmail(email);
        this.agenda.setNome(nome);
        this.agenda.setTelefone(telefone);

        this.dao.inserir(agenda);
        this.NotifyTtoAll();

    }

    public void atualizaContato(int id, String nome, String email, String telefone) {
        this.agenda.setId(id);
        this.agenda.setEmail(email);
        this.agenda.setNome(nome);
        this.agenda.setTelefone(telefone);

        this.dao.atualizar(agenda);
        this.NotifyTtoAll();

    }

    public void excluir(int id) {
        this.agenda.setId(id);
        this.dao.deletar(this.agenda);
        this.NotifyTtoAll();
    }

    public Agenda getAgenda() {
        return agenda;
    }

    public void setAgenda(Agenda agenda) {
        this.agenda = agenda;
    }

    public Dao getDao() {
        return dao;
    }

    public void setDao(Dao dao) {
        this.dao = dao;
    }
    
    public String buscarNome(String nome){
        String resultado="";
        ArrayList array = (ArrayList) this.dao.buscar();
        for (Object array1 : array) {
            
            if  (nome.equals(((Agenda)array1).getNome()) ) {
                resultado = resultado + "\n"+array1.toString();
            }
        }
        return resultado;
    }

}
