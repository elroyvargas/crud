package igu;

import entidades.Persona;
import igu.clientes.ClientesJDialog;
import implementacion.ImplPersona;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class MenuFrame extends JFrame{
    
    
    JLabel lb_nombres    = new JLabel("Nombres: ");
    JLabel lb_ap_paterno = new JLabel("Ap. Paterno: ");
    JLabel lb_ap_materno = new JLabel("Ap. Materno: ");
    JLabel lb_codigo     = new JLabel("Codigo: ");
    JLabel lb_sexo        = new JLabel(" Sexo: ");
    JLabel lb_usuario     = new JLabel(" Usuario: ");
    JLabel lb_pasword     = new JLabel(" Password: ");
    
    JTextField txf_nombres    = new JTextField();
    JTextField txf_ap_paterno = new JTextField();
    JTextField txf_ap_materno = new JTextField();
    JTextField txf_codigo     = new JTextField();
    JTextField txf_sexo       = new JTextField();
    JTextField txf_usuario     = new JTextField();
    JTextField txf_password    = new JTextField();
    JPasswordField psf_password = new JPasswordField(); 
    
    JRadioButton rdbtonM      = new JRadioButton("Masculino");
    JRadioButton rdbtonF      = new JRadioButton("Femenino");
    
    
    //MetodosSistema metodos= new MetodosSistema();
    ImplPersona metodos = new ImplPersona();
             
    
    public MenuFrame(){
        
      menu();
        
      Dimension pantalla = Toolkit.getDefaultToolkit().getScreenSize();
      int height = pantalla.height;
      int width = pantalla.width;
      setSize(width/2, height/2);		

      setLocationRelativeTo(null);		
      setVisible(true);
      //setSize(new Dimension(1200, 1200));
    }
    
    public void iconMethod(){
        
        this.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("icon-main.jpg")));
                
    }
    
    public void menu(){
     JMenuBar menuBar = new JMenuBar();
        
        JMenu menuFile     = new JMenu();
        JMenu menuCustomer = new JMenu();
        JMenu menuProducts = new JMenu();
        JMenu menuVentas   = new JMenu();
        
        JMenuItem menuFileExit               = new JMenuItem();
        
        JMenuItem menuMantenimientoCustomer = new JMenuItem();
        JMenuItem menuMantenimientoViewCustomer  = new JMenuItem();
        
        JMenuItem menuMantenimientoVentas       = new JMenuItem();
        JMenuItem menuMantenimientoViewVentas   = new JMenuItem();
        
        JMenuItem menuMantenimientoProducts     = new JMenuItem();
        JMenuItem menuMantenimientoViewProducts = new JMenuItem();
        
        menuFile.setText("System");
        
        menuFileExit.setText("Salir");
        
        menuCustomer.setText("Customer-Managment");
        menuMantenimientoCustomer.setText("Add-Customer");
        menuMantenimientoViewCustomer.setText("View-Customer");
        
        menuVentas.setText("Ventas");        
        menuMantenimientoVentas.setText("ventas.-Managment");
        menuMantenimientoViewVentas.setText("View-Ventas");
        
        menuProducts.setText("Products");
        menuMantenimientoProducts.setText("Products-Managment");
        menuMantenimientoViewProducts.setText("View-Products");
        
        menuFile.add(menuFileExit);
        
        menuCustomer.add(menuMantenimientoCustomer);
        menuCustomer.add(menuMantenimientoViewCustomer);
        
        menuVentas.add(menuMantenimientoVentas);
        menuVentas.add(menuMantenimientoViewVentas);
        
        menuProducts.add(menuMantenimientoProducts);
        menuProducts.add(menuMantenimientoViewProducts);
                
        
        menuBar.add(menuCustomer);
        menuBar.add(menuProducts);
        menuBar.add(menuVentas);
        menuBar.add(menuFile);
        
        
        setTitle("SISTEMA DE CONTROL DE VENTAS");
        setJMenuBar(menuBar);
        //setSize(new Dimension(1600, 1600));
        
        menuFileExit.addActionListener(
            new ActionListener(){
                public void actionPerformed(ActionEvent e){
                  System.exit(0);
                  LoginJFrame lf = new LoginJFrame();
                  lf.show();
                }
            }
        );
        
        menuMantenimientoVentas.addActionListener(
            new ActionListener(){
                public void actionPerformed(ActionEvent e){
                  String columnas[] = {"Nombres","Ap. Paterno","Ap. Materno","Codigo"};
                  Object filas[][] = new Object[metodos.reportePersonas().size()][4];
                  
          /*        Vector nuevoVector = metodos.reportePersonas();
                  for(int i =0; i<nuevoVector.size();i++){
                      Persona v = (Persona)metodos.reportePersonas().get(i);
                      filas[i][0]=v.getNombre();
                      filas[i][1]=v.getAp_paterno();
                      filas[i][2]=v.getAp_materno();
                      filas[i][3]=v.getCodigo();
                  }
            */      
                  JTable tabla= new JTable(filas, columnas);
                  JScrollPane tabla1= new JScrollPane(tabla);
                  
                    JPanel reporte= new JPanel();
                    reporte.add(tabla1);
                    
                    Object  msg[]={reporte};
                    JOptionPane.showMessageDialog(null, msg, "Reporte", JOptionPane.QUESTION_MESSAGE);
                       
                    
                }
            }
        );
        
        
        
        menuMantenimientoCustomer.addActionListener(
            new ActionListener(){
                public void actionPerformed(ActionEvent e){
                    
                    ClientesJDialog cf = new ClientesJDialog(null, rootPaneCheckingEnabled);
                    cf.show();
                    
                    /*
                    JPanel pan1 = new JPanel(new GridLayout(1,2));
                    pan1.add(lb_nombres);
                    pan1.add(txf_nombres);
                    
                    JPanel pan2 = new JPanel(new GridLayout(1,2));
                    pan2.add(lb_ap_paterno);
                    pan2.add(txf_ap_paterno);
                    
                    JPanel pan3 = new JPanel(new GridLayout(1,2));
                    pan3.add(lb_ap_materno);
                    pan3.add(txf_ap_materno);
                    
                    JPanel pan4 = new JPanel(new GridLayout(1,2));
                    pan4.add(lb_codigo);
                    pan4.add(txf_codigo);
                    
                    ButtonGroup bgsexo = new ButtonGroup();
                    bgsexo.add(rdbtonM);
                    bgsexo.add(rdbtonF);
                    
                    JPanel pan5 = new JPanel(new GridLayout(1,3));
                    pan5.add(lb_sexo);                   
                    pan5.add(rdbtonM);
                    pan5.add(rdbtonF);
                    
                    JPanel pan6 = new JPanel(new GridLayout(1,2));
                    pan6.add(lb_usuario);
                    pan6.add(txf_usuario);
                    
                    JPanel pan7 = new JPanel(new GridLayout(1,2));
                    pan7.add(lb_pasword);
                    pan7.add(psf_password);
                    
                    
                    Object msg []= {pan1, pan2, pan3, pan4, pan5, pan6, pan7};
                    
                    if(JOptionPane.showOptionDialog(null, msg,"Registrar", JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE,null,null,null)==JOptionPane.OK_OPTION){
                    
                        Persona dp= new Persona();
                        dp.setNombre(txf_nombres.getText());
                        dp.setAp_paterno(txf_ap_paterno.getText());
                        dp.setAp_materno(txf_ap_materno.getText());
                        dp.setCodigo(txf_codigo.getText());
                        dp.setUsuario(txf_usuario.getText());
                        dp.setPassword(psf_password. getText());
                        
                        if(rdbtonF.isSelected()==true){  
                        dp.setSexo("F");
                        }
                        if(rdbtonM.isSelected()==true){  
                        dp.setSexo("M");
                        }
                        

                        if(!txf_nombres.getText().equals("")|| !txf_ap_paterno.getText().equals("") || !txf_ap_materno.getText().equals("") || !txf_codigo.getText().equals("")  ){
                            metodos.registrarPersona(dp);
                            txf_nombres.setText("");
                            txf_ap_paterno.setText("");
                            txf_ap_materno.setText("");
                            txf_usuario.setText("");
                            psf_password.setText("");
                            txf_codigo.setText("");
                            
                                 JOptionPane.showMessageDialog(
                                        null,
                                        "Se registro conExito", 
                                        "Registro",
                                        JOptionPane.INFORMATION_MESSAGE);
                        }else{
                                 JOptionPane.showMessageDialog(
                                        null,
                                        "No se registro", 
                                        "Error/Advertencia",
                                        JOptionPane.INFORMATION_MESSAGE);
                        }
                    }
                   
                    
                    */
                    
                }
            }
        );
        
        
    }
    

    
}
