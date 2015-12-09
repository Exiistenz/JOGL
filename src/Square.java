import com.jogamp.opengl.GL;
import com.jogamp.opengl.GL2;
import com.jogamp.opengl.GLAutoDrawable;

//import com.jogamp.opengl.GL;
//import com.jogamp.opengl.GL2;
//import com.jogamp.opengl.GLAutoDrawable;
import com.jogamp.opengl.GLEventListener;
import com.jogamp.opengl.glu.GLU;

public class Square implements GLEventListener {
	private double theta = 0;	
	
	private float x;
	
	private float y;
	
	private float z;
	
	public Square() {
	}
	
	public Square(float axeX, float axeY, float axeZ) {
		x = axeX;
		y = axeY;	
		z = axeZ;	
	}
	
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

        gl.glClear(GL.GL_COLOR_BUFFER_BIT | GL.GL_DEPTH_BUFFER_BIT);
        gl.glRotatef((float)theta, 1.0f, 1.0f, 1.0f);    
        gl.glBegin(GL2.GL_QUADS);
        
        //Face Devant
        gl.glColor3d(1, 0, 0);
        gl.glVertex3f(-0.5f,-0.5f,0.5f);
        gl.glVertex3f(0.5f,-0.5f,0.5f);
        gl.glVertex3f(0.5f,0.5f,0.5f);
        gl.glVertex3f(-0.5f,0.5f,0.5f);
        
        //Face Droite      
        gl.glColor3d(0, 1, 0);
        gl.glVertex3f(0.5f,-0.5f,0.5f);
        gl.glVertex3f(0.5f,-0.5f,-0.5f);
        gl.glVertex3f(0.5f,0.5f,-0.5f);
        gl.glVertex3f(0.5f,0.5f,0.5f);
        
        //Face Haut     
        gl.glColor3d(0, 0, 1);
        gl.glVertex3f(-0.5f,0.5f,0.5f);
        gl.glVertex3f(0.5f,0.5f,0.5f);
        gl.glVertex3f(0.5f,0.5f,-0.5f);
        gl.glVertex3f(-0.5f,0.5f,-0.5f);
        
        //Face Fond      
        gl.glColor3d(1, 1, 0);
        gl.glVertex3f(-0.5f,-0.5f,-0.5f);
        gl.glVertex3f(0.5f,-0.5f,-0.5f);
        gl.glVertex3f(0.5f,0.5f,-0.5f);
        gl.glVertex3f(-0.5f,0.5f,-0.5f);
        
        //Face Gauche     
        gl.glColor3d(0, 1, 1);
        gl.glVertex3f(-0.5f,-0.5f,0.5f);
        gl.glVertex3f(-0.5f,-0.5f,-0.5f);
        gl.glVertex3f(-0.5f,0.5f,-0.5f);
        gl.glVertex3f(-0.5f,0.5f,0.5f);
        
        //Face Bas    
        gl.glColor3d(1, 0, 1);
        gl.glVertex3f(-0.5f,-0.5f,0.5f);
        gl.glVertex3f(0.5f,-0.5f,0.5f);
        gl.glVertex3f(0.5f,-0.5f,-0.5f);
        gl.glVertex3f(-0.5f,-0.5f,-0.5f);
        
        //gl.glTranslatef(0f, 10f, 1000f);
        
        gl.glEnd();
    }       
}
