import com.jogamp.opengl.GL;
import com.jogamp.opengl.GL2;
import com.jogamp.opengl.GLAutoDrawable;


public class Cube {
	private double theta = 0;	
	private float x;	
	private float y;	
	private float z;
	private float l;
	
	public Cube() {
		
	}
	
	public Cube(float axeX, float axeY, float axeZ, float size) {
		x = axeX;
		y = axeY;	
		z = axeZ;	
		l = size;
		Render3D.list3DObject.add(this);
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
        
        //Face Devant
        /*gl.glColor3d(1, 0, 0);
        gl.glVertex3f(x, y, z);
        gl.glVertex3f(x+l, y+l, z+l);
        gl.glVertex3f(x+l, y+l, z+l);
        gl.glVertex3f(x+l, y+l, z+l);
        
        //Face Droite      
        gl.glColor3d(0, 1, 0);
        gl.glVertex3f(x+l, y+l, z+l);
        gl.glVertex3f(x+l, y+l, z+l);
        gl.glVertex3f(x+l, y+l, z+l);
        gl.glVertex3f(x+l, y+l, z+l);
        
        //Face Haut     
        gl.glColor3d(0, 0, 1);
        gl.glVertex3f(x+l, y+l, z+l);
        gl.glVertex3f(x+l, y+l, z+l);
        gl.glVertex3f(x+l, y+l, z+l);
        gl.glVertex3f(x+l, y+l, z+l);
        
        //Face Fond      
        gl.glColor3d(1, 1, 0);
        gl.glVertex3f(x+l, y+l, z+l);
        gl.glVertex3f(x+l, y+l, z+l);
        gl.glVertex3f(x+l, y+l, z+l);
        gl.glVertex3f(x+l, y+l, z+l);
        
        //Face Gauche     
        gl.glColor3d(0, 1, 1);
        gl.glVertex3f(x+l, y+l, z+l);
        gl.glVertex3f(x+l, y+l, z+l);
        gl.glVertex3f(x+l, y+l, z+l);
        gl.glVertex3f(x+l, y+l, z+l);
        
        //Face Bas    
        gl.glColor3d(1, 0, 1);
        gl.glVertex3f(x+l, y+l, z+l);
        gl.glVertex3f(x+l, y+l, z+l);
        gl.glVertex3f(x+l, y+l, z+l);
        gl.glVertex3f(x+l, y+l, z+l);*/
        
        gl.glEnd();
    }   
}
