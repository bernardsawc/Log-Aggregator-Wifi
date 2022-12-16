package com.logawifi.app.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Ipv4Address {
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
            throw new IllegalArgumentException("tentativa de acessar um indice fora do array de octetos do ip");
        return ((Short) this.getOctet(octetIndex)).toString();
    }
    public short getOctet(short octetIndex) throws IllegalArgumentException{
        if(!isValidOctetIndex(octetIndex))
            throw new IllegalArgumentException("tentativa de acessar um indice fora do array de octetos do ip");
        return (short) (address[octetIndex]+128);
    }
    public void setOctetValue(short octetIndex, short octetValue) throws IllegalArgumentException{
        if(!isValidOctetIndex(octetIndex))
            throw new IllegalArgumentException("tentativa de acessar um indice fora do array de octetos do ip");
        if(!isValidOctetValue(octetValue))
            throw new IllegalArgumentException("tentativa de atribuir a um octeto um valor incompativel com o seu tipo");
        address[octetIndex] = 
                                (
                                    (Short)(
                                        (Integer) (
                                            Short.valueOf(octetValue).shortValue()
                                                +
                                            Short.valueOf("-128").shortValue()
                                        )
                                    )
                                    .shortValue()
                                )
                                .byteValue();
        

    }

    private boolean isValidOctetValue(short octetValue){
        if(octetValue>255 || octetValue<0)
            return false;
        return true;
    }

    private boolean isValidOctetIndex(short octetIndex){
        if(octetIndex<0 || octetIndex>3)
            return false;
        return true;
    }


}
