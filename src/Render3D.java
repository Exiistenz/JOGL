import java.util.ArrayList;

import com.jogamp.opengl.GL;
import com.jogamp.opengl.GL2;
import com.jogamp.opengl.GLAutoDrawable;
import com.jogamp.opengl.GLEventListener;

public class Render3D implements GLEventListener {
    private double theta = 0;
	
	public static ArrayList<Object> list3DObject = new ArrayList<Object>();
    
	@Override
	public void display(GLAutoDrawable arg0) {
		update();
        render(arg0);		
	}

	@Override
	public void dispose(GLAutoDrawable arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void init(GLAutoDrawable arg0) {	
		 GL2 gl = arg0.getGL().getGL2();
		 gl.glClearColor(0f, 0f, 0f, 0f);
		 gl.glClearDepthf(1.0f);
		 gl.glEnable(GL2.GL_DEPTH_TEST);
		 gl.glDepthFunc(GL2.GL_LEQUAL);
		 gl.glHint(GL2.GL_PERSPECTIVE_CORRECTION_HINT, GL2.GL_NICEST);
	}

	@Override
	public void reshape(GLAutoDrawable arg0, int arg1, int arg2, int arg3,
			int arg4) {	
		/*GL2 gl = arg0.getGL().getGL2();
		gl.glMatrixMode(GL2.GL_PROJECTION);
		gl.glLoadIdentity();
		(new GLU()).gluPerspective(45f, (float)arg3/(float)arg4, 0.1f, 100f);
		gl.glMatrixMode(GL2.GL_MODELVIEW);
		gl.glLoadIdentity();*/
	}
	
	public void update() {
        theta += 0.01;
    }

    public void render(GLAutoDrawable drawable) {
        GL2 gl = drawable.getGL().getGL2();

        gl.glClear(GL.GL_COLOR_BUFFER_BIT);
        gl.glRotatef((float)theta, 1.0f, 1.0f, 1.0f);
        gl.glBegin(GL2.GL_QUADS);
        gl.glEnd();
        
       Cube myCube = new Cube();
       myCube.render(drawable);
        
        /*for (Object obj : list3DObject) {
			((Cube) obj).render(drawable);
		}*/
        
        //Cube myCubeBis = new Cube();
        //myCubeBis.render(drawable);
    }       
}
