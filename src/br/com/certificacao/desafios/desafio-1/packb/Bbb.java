package br.com.certificacao.desafios.packb;

import br.com.certificacao.desafios.packa.Aaa;

public class Bbb extends Aaa {

    int y = 10;
    public void print () {
        Aaa a = new Aaa();
        System.out.println(a.y + y);
    }
}