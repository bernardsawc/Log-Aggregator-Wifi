package com.logawifi.app.entities;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class Ipv4AddressTest {

    @Test
    public void validaValorInicialDoPrimeiroOcteto(){
        final Ipv4Address ipv4Address = new Ipv4Address();
        assertEquals((short) 0, ipv4Address.getOctet((short)0));
    }
    @Test
    public void validaValorInicialDoSegundoOcteto(){
        final Ipv4Address ipv4Address = new Ipv4Address();
        assertEquals((short) 0, ipv4Address.getOctet((short)1));
    }
    @Test
    public void validaValorInicialDoTerceiroOcteto(){
        final Ipv4Address ipv4Address = new Ipv4Address();
        assertEquals((short) 0, ipv4Address.getOctet((short)2));
    }
    @Test
    public void validaValorInicialDoQuartoOcteto(){
        final Ipv4Address ipv4Address = new Ipv4Address();
        assertEquals((short) 0, ipv4Address.getOctet((short)3));
    }
    @Test
    public void validaSetarTodosOsValoresValidosAoPrimeiroOcteto(){
        final Ipv4Address ipv4Address = new Ipv4Address();
        final short valorMinimo=0, valorMaximo=255;
        for(short valorAtual=valorMinimo;valorAtual<=valorMaximo;valorAtual++){
            ipv4Address.setOctetValue((short) 0, valorAtual);
            if(valorAtual!=ipv4Address.getOctet((short) 0))
                assertFalse(true);
        }
        assertTrue(true);
    }
    @Test
    public void validaSetarTodosOsValoresValidosAoSegundoOcteto(){
        final Ipv4Address ipv4Address = new Ipv4Address();
        final short valorMinimo=0, valorMaximo=255;
        for(short valorAtual=valorMinimo;valorAtual<=valorMaximo;valorAtual++){
            ipv4Address.setOctetValue((short) 1, valorAtual);
            if(valorAtual!=ipv4Address.getOctet((short) 1))
                assertFalse(true);
        }
        assertTrue(true);
    }
    @Test
    public void validaSetarTodosOsValoresValidosAoTerceiroOcteto(){
        final Ipv4Address ipv4Address = new Ipv4Address();
        final short valorMinimo=0, valorMaximo=255;
        for(short valorAtual=valorMinimo;valorAtual<=valorMaximo;valorAtual++){
            ipv4Address.setOctetValue((short) 2, valorAtual);
            if(valorAtual!=ipv4Address.getOctet((short) 2))
                assertFalse(true);
        }
        assertTrue(true);
    }
    @Test
    public void validaSetarTodosOsValoresValidosAoQuartoOcteto(){
        final Ipv4Address ipv4Address = new Ipv4Address();
        final short valorMinimo=0, valorMaximo=255;
        for(short valorAtual=valorMinimo;valorAtual<=valorMaximo;valorAtual++){
            ipv4Address.setOctetValue((short) 3, valorAtual);
            if(valorAtual!=ipv4Address.getOctet((short) 3))
                assertFalse(true);
        }
        assertTrue(true);
    }
}
