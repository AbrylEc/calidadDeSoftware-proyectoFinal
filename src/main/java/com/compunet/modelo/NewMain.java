
package com.compunet.modelo;

import org.apache.log4j.Logger;

public class NewMain {
	
	private static Logger log = Logger.getLogger(NewMain.class);

    public static void main(String[] args) {
        CBDD cnx = new CBDD();
        log.info(cnx.getCnx());
    }

}
