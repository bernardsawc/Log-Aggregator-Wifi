package com.logawifi.app.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Transient;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Ipv4Address {

    @Transient
    private static final String MENSAGEM_ERRO = "tentativa de acessar um indice fora do array de octetos do ip";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private short id;

    @Column(length = 4)
    private byte[] address;

    public Ipv4Address(){
        this.address = new byte[4];
        this.setOctetValue((short)0, (short)0);
        this.setOctetValue((short)1, (short)0);
        this.setOctetValue((short)2, (short)0);
        this.setOctetValue((short)3, (short)0);
    }

    public String getOctetAsString(short octetIndex) throws IllegalArgumentException{
        if(!isValidOctetIndex(octetIndex))
            throw new IllegalArgumentException(MENSAGEM_ERRO);
        return ((Short) this.getOctet(octetIndex)).toString();
    }
    public short getOctet(short octetIndex) throws IllegalArgumentException{
        if(!isValidOctetIndex(octetIndex))
            throw new IllegalArgumentException(MENSAGEM_ERRO);
        return (short) (address[octetIndex]+128);
    }
    public void setOctetValue(short octetIndex, short octetValue) throws IllegalArgumentException{
        if(!isValidOctetIndex(octetIndex))
            throw new IllegalArgumentException(MENSAGEM_ERRO);
        if(!isValidOctetValue(octetValue))
            throw new IllegalArgumentException("tentativa de atribuir a um octeto um valor incompativel com o seu tipo");
        address[octetIndex] = 
                                (
                                    (Short)(
                                        (Integer) (
                                            octetValue
                                                +
                                            Short.parseShort("-128")
                                        )
                                    )
                                    .shortValue()
                                )
                                .byteValue();
        

    }

    private boolean isValidOctetValue(short octetValue){
        return !(octetValue>255 || octetValue<0);
    }

    private boolean isValidOctetIndex(short octetIndex){
        return !(octetIndex<0 || octetIndex>3);
    }


    @Override
    public String toString() {
        return new StringBuilder()
            .append(getOctetAsString((short)0))
            .append(".")
            .append(getOctetAsString((short)1))
            .append(".")
            .append(getOctetAsString((short)2))
            .append(".")
            .append(getOctetAsString((short)3))
            .toString();
    }



}
