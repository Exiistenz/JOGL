import com.jogamp.opengl.GL;
import com.jogamp.opengl.GL2;
import com.jogamp.opengl.GLAutoDrawable;
import jogl_core;


public class Cube {
	private double theta = 0;	
	private float x;	
	private float y;	
	private float z;
	private float l;
	private float tx; 
	private float ty; 
	private float tz;
	private float rotX = 0;
	private float rotY = 0;
	private float rotZ = 0;
	private float orbX; 
	private float orbY;
	private float orbZ;
	private int texture;
	
	public Cube() {
		
	}
	
	public Cube(float x, float y, float z, float l, float tx, float ty, float tz, float ox, float oy, float oz, int t) {
		this.x = x;
		this.y = y;
		this.z = z;
		this.l = l;
		this.tx = tx;
		this.ty = ty;
		this.tz = tz;
		rotX = ox;
		rotY = oy;
		rotZ = oz;
		texture = t;
		Render3D.list3DObject.add(this);
	}
	
	public void update() {
        theta += 0.01;
    }

	public void rneder(GLAutoDrawable drawable) {
        GL2 gl = drawable.getGL().getGL2();

        gl.glLoadIdentity();

        gl.glPushMatrix();

        gl.glTranslatef(this.tx, this.ty, this.tz);

        gl.glRotatef(rotX, 1.0f, 0.0f, 0.0f);
		gl.glRotatef(rotY, 0.0f, 1.0f, 0.0f);
		gl.glRotatef(rotZ, 0.0f, 0.0f, 1.0f);

        gl.glBegin(GL2.GL_QUADS);

        // Back - red face
        gl.glColor3f(1, 0, 0);
        gl.glVertex3f(this.x, -this.x, this.x);
        gl.glVertex3f(-this.x, -this.x, this.x);
        gl.glVertex3f(-this.x, this.x, this.x);
        gl.glVertex3f(this.x, this.x, this.x);

        // Bottom - orange face
        gl.glColor3f(1, .5f, 0);
        gl.glVertex3f(this.x, -this.x, this.x);
        gl.glVertex3f(-this.x, -this.x, this.x);
        gl.glVertex3f(-this.x, -this.x, -this.x);
        gl.glVertex3f(this.x, -this.x, -this.x);

        // Left - blue face
        gl.glColor3f(0, 0, 1);
        gl.glVertex3f(-this.x, -this.x, this.x);
        gl.glVertex3f(-this.x, -this.x, -this.x);
        gl.glVertex3f(-this.x, this.x, -this.x);
        gl.glVertex3f(-this.x, this.x, this.x);

        // Right - violet face
        gl.glColor3f(1, 0, .5f);
        gl.glVertex3f(this.x, this.x, -this.x);
        gl.glVertex3f(this.x, this.x, this.x);
        gl.glVertex3f(this.x, -this.x, this.x);
        gl.glVertex3f(this.x, -this.x, -this.x);

        // Top - green face
        gl.glColor3f(0, 1, 0);
        gl.glVertex3f(this.x, this.x, -this.x);
        gl.glVertex3f(-this.x, this.x, -this.x);
        gl.glVertex3f(-this.x, this.x, this.x);
        gl.glVertex3f(this.x, this.x, this.x);

        // Front - yellow face
        gl.glColor3f(1, 1, 0);
        gl.glVertex3f(-this.x, -this.x, -this.x);
        gl.glVertex3f(this.x, -this.x, -this.x);
        gl.glVertex3f(this.x, this.x, -this.x);
        gl.glVertex3f(-this.x, this.x, -this.x);

        gl.glEnd();

        gl.glPopMatrix();
    }
	
    /*public void render(GLAutoDrawable drawable) {
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
        gl.glColor3d(1, 0, 0);
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
        gl.glVertex3f(x+l, y+l, z+l);
        
        gl.glEnd();
    }*/
}
