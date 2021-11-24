/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package PQ_CONTROLADORES;

//import PQ_VENTANAS.FRM_Login;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.SplashScreen;

/**
 *
 * @author ANDY FC
 */
public final class ScreenSplash
{
    final SplashScreen splash ;
    //texto que se muestra a medida que se va cargando el screensplah
    final String[] texto = {"CONSTRUCTORA MLS SAC" ,"Configuración", "Cargando Librerias",
                            "Configurando Servidor","Iniciando Formularios","Inicializando Iconos","Propiedades",
                            "Menú Listo", "Archivos Iniciados","Iniciando Base de Datos" , "Conectando",
                            "ANDY FIGUEROA CASTILLO-DESARROLLADOR","Servidor"};
    public ScreenSplash() 
    {
        splash = SplashScreen.getSplashScreen();
    }
    public void animar()
    {
        if (splash != null)
        {
            Graphics2D g = splash.createGraphics();
            for(int i=1; i<10/*texto.length*/; i++)
            {                       
////                //se pinta texto del array
//                g.setColor( new Color(240,240,240));//color de fondo
//                g.fillRect(203, 328,280,12);//para tapar texto anterior  g.fillRect(203, 328,280,12);
//                g.setColor(Color.white);//color de texto 
//                g.drawString("INICIANDO: "+texto[i-1]+"...", 203, 338); //g.drawString("INICIANDO: "+texto[i-1]+"...", 203, 338)             
//                g.setColor(Color.green);//color de barra de progeso
//                g.fillRect(204, 308,(i*307/texto.length), 12);//la barra de progreso
//                //se pinta una linea segmentada encima de la barra verde
//                float dash1[] = {2.0f};
//                BasicStroke dashed = new BasicStroke(9.0f,BasicStroke.CAP_BUTT,BasicStroke.JOIN_MITER,5.0f, dash1, 0.0f);
//                g.setStroke(dashed);
//                g.setColor(Color.GREEN);//color de barra de progeso
//                g.setColor( new Color(4,52,101));
//                g.drawLine(205,314, 510, 314);                
//                //se actualiza todo
                splash.update();
                try 
                {
                    Thread.sleep(400);
                } catch(InterruptedException e) 
                { }
            }
            splash.close();
        }
        try 
        {
//            new FRM_Login().setVisible(true);
        }
        catch(Exception e) 
        {
            System.out.println(e.getMessage()+"que mierda pasa");
        }
        System.gc();
   }
}
