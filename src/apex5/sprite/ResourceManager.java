package apex5.sprite;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.imageio.ImageIO;


public class ResourceManager {

	private static ResourceManager _instance = new ResourceManager();
	private final Map<String, Sprite2D> spriteMap;

	private ResourceManager() {
		spriteMap = new HashMap<String, Sprite2D>();

	}

	public final static ResourceManager getInstance() {
		return _instance;
	}

	/*public void loadResources(InputStream is) throws SlickException {
		loadResources(is, false);
	}

	public void loadResources(InputStream is, boolean deferred)
			throws SlickException {
		DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory
				.newInstance();
		DocumentBuilder docBuilder = null;
		try {
			docBuilder = docBuilderFactory.newDocumentBuilder();
		} catch (ParserConfigurationException e) {
			throw new SlickException("Could not load resources", e);
		}
		Document doc = null;
		try {
			doc = docBuilder.parse(is);
		} catch (SAXException e) {
			throw new SlickException("Could not load resources", e);
		} catch (IOException e) {
			throw new SlickException("Could not load resources", e);
		}
		// normalize text representation
		doc.getDocumentElement().normalize();
		NodeList listResources = doc.getElementsByTagName("resource");
		int totalResources = listResources.getLength();
		if (deferred) {
			LoadingList.setDeferredLoading(true);
		}
		for (int resourceIdx = 0; resourceIdx < totalResources; resourceIdx++) {
			Node resourceNode = listResources.item(resourceIdx);
			if (resourceNode.getNodeType() == Node.ELEMENT_NODE) {
				Element resourceElement = (Element) resourceNode;
				String type = resourceElement.getAttribute("type");
				if (type.equals("sprite")) {
					addElementAsImage(resourceElement);
				}
			}
		}
	}

	private final void addElementAsImage(Element resourceElement)
			throws SlickException {
		loadSprite(resourceElement.getAttribute("id"),
				resourceElement.getTextContent());
	}

	public Sprite2D loadSprite(String id, String path) throws SlickException {
		if (path == null || path.length() == 0)
			throw new SlickException("Sprite resource [" + id
					+ "] has invalid path");
		Sprite2D sprite = null;
		try {
			// image = new Image(path);
			File f = new File(path);
			FileInputStream fileIn = new FileInputStream(f);

			ObjectInputStream in = new ObjectInputStream(fileIn);
			SpriteData sd = (SpriteData) in.readObject();
			sprite = new Sprite2D(CreateImage(sd.getSpriteSheet()), sd);

		} catch (FileNotFoundException e) {
			throw new SlickException("Could not load image", e);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.spriteMap.put(id, sprite);
		return sprite;
	}*/

	/*private Image CreateImage(Colour[][] spriteSheet) {
		Image slickImage = null;
		Texture texture = null;
		try {
			texture = BufferedImageUtil.getTexture("",
					CreateBufferedImage(spriteSheet), GL11.GL_NEAREST);
			slickImage = new Image(texture.getImageWidth(),
					texture.getImageHeight());

		} catch (IOException e) {
			System.out.println("File IO Error @ ResourceManager");
			e.printStackTrace();
		} catch (SlickException e) {
			System.out.println("Slick Error @ ResourceManager");
			e.printStackTrace();
		}

		slickImage.setTexture(texture);

		return slickImage;
	}*/
	
	/*public Sprite2D loadSpriteFromData(String id, String path) throws IOException{
		if (path == null || path.length() == 0)
			throw new IOException("Sprite resource [" + id
					+ "] has invalid path");
		Sprite2D sprite = null;
		try {
			// image = new Image(path);
			File f = new File(path);
			FileInputStream fileIn = new FileInputStream(f);

			ObjectInputStream in = new ObjectInputStream(fileIn);
			SpriteData sd = (SpriteData) in.readObject();
			//Fix DIS SHIT
			//sprite = new Sprite2D(CreateImage(sd.getSpriteSheet()), sd);

		} catch (FileNotFoundException e) {
			throw new FileNotFoundException("Could not load image: "+e.getMessage());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.spriteMap.put(id, sprite);
		return sprite;
	}
	private BufferedImage CreateImage(Colour[][] spriteSheet) {
		// TODO Auto-generated method stub
		return null;
	}*/

	public Sprite2D loadSpriteMap(String resourcePath, String[] animNames, int collumns, int speed){
		try {
			BufferedImage b =ImageIO.read(ResourceManager.class.getResourceAsStream("/"+resourcePath));
			return new Sprite2D(b,animNames,collumns,speed);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	//public Sprite2D LoadImage(){
		
	//}

	/*private BufferedImage CreateBufferedImage(Colour[][] imageArray) {
		int width = imageArray[0].length;
		int height = imageArray.length;
		BufferedImage ret;

		ret = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

		WritableRaster raster = ret.getRaster();

		for (int y = 0; y < height; y++) {
			for (int x = 0; x < width; x++) {

				raster.setSample(x, y, 0, (int) (imageArray[y][x].getR() * 255));
				raster.setSample(x, y, 1, (int) (imageArray[y][x].getG() * 255));
				raster.setSample(x, y, 2, (int) (imageArray[y][x].getB() * 255));

			}
		}

		return ret;
	}*/

	public final Sprite2D getSprite(String ID) {
		return spriteMap.get(ID);
	}

}
