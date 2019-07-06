package com.base.engine.core;

import com.base.engine.components.Camera;
import com.base.engine.components.DirectionalLight;
import com.base.engine.components.MeshRenderer;
import com.base.engine.components.PointLight;
import com.base.engine.components.SpotLight;
import com.base.engine.internalGame.Game;
import com.base.engine.math.Quaternion;
import com.base.engine.math.Vector2f;
import com.base.engine.math.Vector3f;
import com.base.engine.rendering.Material;
import com.base.engine.rendering.Mesh;
import com.base.engine.rendering.Texture;
import com.base.engine.rendering.Vertex;
import com.base.engine.rendering.Window;
import com.base.engine.util.Attenuation;
import com.base.engine.util.Color;

public class TestGame extends Game {

	public TestGame() {
		// init();
	}

	private GameObject dirLight, dirLight2, pLight, sLight;
	private DirectionalLight dLight, dLight2;
	private PointLight pointLight;
	private SpotLight spotLight;

	public void init() {
//
//		// cam = new Camera();
//		dirLight = new GameObject();
//		dirLight2 = new GameObject();
//		dLight = new DirectionalLight(new Color(0, 0, 1), 0.4f);
//
//		dLight2 = new DirectionalLight(new Color(0, 1, 1), 0.4f);
//		pLight = new GameObject();
//		pointLight = new PointLight(new Color(1, 0, 0), 0.4f, new Attenuation(0, 0, 1));
//		sLight = new GameObject();
//		spotLight = new SpotLight(new Color(1, 1, 1), 0.8f, new Attenuation(0, 0, 0.1f), 0.7f);
//
//		float fieldDepth = 10.0f;
//		float fieldWidth = 10.0f;
//
//		Vertex[] vertices = new Vertex[] {
//				new Vertex(new Vector3f(-fieldWidth, 0.0f, -fieldDepth), new Vector2f(0.0f, 0.0f)),
//				new Vertex(new Vector3f(-fieldWidth, 0.0f, fieldDepth * 3), new Vector2f(0.0f, 1.0f)),
//				new Vertex(new Vector3f(fieldWidth * 3, 0.0f, -fieldDepth), new Vector2f(1.0f, 0.0f)),
//				new Vertex(new Vector3f(fieldWidth * 3, 0.0f, fieldDepth * 3), new Vector2f(1.0f, 1.0f)) };
//
//		int indices[] = { 0, 1, 2, 2, 1, 3 };
//
//		Mesh mesh = new Mesh(vertices, indices, true);
//		// Mesh mesh = new Mesh("IronMan.obj", true);
//		// new Mesh(vertices, indices, true);
//		Material material = new Material(new Texture("defaultTexture.png"), new Vector3f(1, 1, 1), 1, 8);
//
//		MeshRenderer meshRenderer = new MeshRenderer(mesh, material);
//
//		GameObject planeObject = new GameObject();
//		planeObject.addComponent(meshRenderer);
//		planeObject.getTransform().getPosition().set(0, -1, 5);
//		planeObject.getTransform().setScale(5, 5, 5);
//		// planeObject.getTransform().setScale(0.25f, 0.25f, 0.25f);
//
//		getRootObject().addChild(planeObject);
//		GameObject cam = new GameObject().addComponent(new Camera((float) Math.toRadians(70f),
//				(float) Window.getWidth() / (float) Window.getHeight(), 0.01f, 1000.0f));
//		getRootObject().addChild(cam);
//		//cam.addComponent(spotLight);s
//		dirLight.addComponent(dLight);
//		dirLight2.addComponent(dLight2);
//		pLight.addComponent(pointLight);
//		// sLight.addComponent(spotLight);
//		//spotLight.getTransform().setRotation(new Quaternion(new Vector3f(0, 1, 0), (float) Math.toRadians(90.0f)));
//		super.getRootObject().addChild(dirLight);
//		dirLight.getTransform().setRotation(new Quaternion(new Vector3f(0, 1, 1), (float) Math.toRadians(180.0f)));
//		// getRootObject().addChild(dirLight2);
//		// getRootObject().addChild(pLight);
//		// getRootObject().addChild(sLight);
//		// dLight.getTransform().setRotation(new Quaternion(new Vector3f(1, 0, 0),
//		// (float) Math.toRadians(45.0f)));

		float fieldDepth = 10.0f;
		float fieldWidth = 10.0f;

		Vertex[] vertices = new Vertex[] {
				new Vertex(new Vector3f(-fieldWidth, 0.0f, -fieldDepth), new Vector2f(0.0f, 0.0f)),
				new Vertex(new Vector3f(-fieldWidth, 0.0f, fieldDepth * 3), new Vector2f(0.0f, 1.0f)),
				new Vertex(new Vector3f(fieldWidth * 3, 0.0f, -fieldDepth), new Vector2f(1.0f, 0.0f)),
				new Vertex(new Vector3f(fieldWidth * 3, 0.0f, fieldDepth * 3), new Vector2f(1.0f, 1.0f)) };

		int indices[] = { 0, 1, 2, 2, 1, 3 };

		Vertex[] vertices2 = new Vertex[] {
				new Vertex(new Vector3f(-fieldWidth / 10, 0.0f, -fieldDepth / 10), new Vector2f(0.0f, 0.0f)),
				new Vertex(new Vector3f(-fieldWidth / 10, 0.0f, fieldDepth / 10 * 3), new Vector2f(0.0f, 1.0f)),
				new Vertex(new Vector3f(fieldWidth / 10 * 3, 0.0f, -fieldDepth / 10), new Vector2f(1.0f, 0.0f)),
				new Vertex(new Vector3f(fieldWidth / 10 * 3, 0.0f, fieldDepth / 10 * 3), new Vector2f(1.0f, 1.0f)) };

		int indices2[] = { 0, 1, 2, 2, 1, 3 };

		Mesh mesh2 = new Mesh(vertices2, indices2, true);

		Mesh mesh = new Mesh(vertices, indices, true);
		Material material = new Material(new Texture("defaultTexture.png"), new Vector3f(1, 1, 1), 1, 8);

		MeshRenderer meshRenderer = new MeshRenderer(mesh, material);

		GameObject planeObject = new GameObject();
		planeObject.addComponent(meshRenderer);
		planeObject.getTransform().getPosition().set(0, -1, 5);

		GameObject directionalLightObject = new GameObject();
		DirectionalLight directionalLight = new DirectionalLight(new Vector3f(0, 0, 1), 0.4f);

		directionalLightObject.addComponent(directionalLight);

		GameObject pointLightObject = new GameObject();
		pointLightObject.addComponent(new PointLight(new Vector3f(0, 1, 0), 0.4f, new Vector3f(0, 0, 1)));

		SpotLight spotLight = new SpotLight(new Vector3f(0, 1, 1), 0.4f, new Vector3f(0, 0, 0.1f), 0.7f);

		GameObject spotLightObject = new GameObject();
		spotLightObject.addComponent(spotLight);

		spotLightObject.getTransform().getPosition().set(5, 0, 5);
		spotLightObject.getTransform()
				.setRotation(new Quaternion(new Vector3f(0, 1, 0), (float) Math.toRadians(90.0f)));

		getRootObject().addChild(planeObject);
		getRootObject().addChild(directionalLightObject);
		getRootObject().addChild(pointLightObject);
		getRootObject().addChild(spotLightObject);

		// getRootObject().addChild(new GameObject().addComponent(new
		// Camera((float)Math.toRadians(70.0f),
		// (float)Window.getWidth()/(float)Window.getHeight(), 0.01f, 1000.0f)));

		GameObject testMesh1 = new GameObject().addComponent(new MeshRenderer(mesh2, material));
		GameObject testMesh2 = new GameObject().addComponent(new MeshRenderer(mesh2, material));

		testMesh1.getTransform().getPosition().set(0, 2, 0);
		testMesh1.getTransform().setRotation(new Quaternion(new Vector3f(0, 1, 0), 0.4f));

		testMesh2.getTransform().getPosition().set(0, 0, 5);

		testMesh1.addChild(testMesh2);
		testMesh2.addChild(new GameObject().addComponent(new Camera((float) Math.toRadians(70.0f),
				(float) Window.getWidth() / (float) Window.getHeight(), 0.01f, 1000.0f)));

		getRootObject().addChild(testMesh1);

		directionalLight.getTransform().setRotation(new Quaternion(new Vector3f(1, 0, 0), (float) Math.toRadians(-45)));

	}
}
