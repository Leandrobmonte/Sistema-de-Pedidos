/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalho_pos.tb.bussines;

import java.sql.Connection;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import trabalho_pos.tp.domain.Cliente;

/**
 *
 * @author leand
 */
public class ClienteBussinesTest {
    
    public ClienteBussinesTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of cadastrarCliente method, of class ClienteBussines.
     */
    @Test
    public void testCadastrarCliente() {
        System.out.println("cadastrarCliente");
        Connection con = null;
        Cliente cliente = null;
        ClienteBussines instance = new ClienteBussines();
        instance.cadastrarCliente(con, cliente);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
