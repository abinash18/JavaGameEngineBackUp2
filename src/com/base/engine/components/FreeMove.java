package com.base.engine.components;

import static com.base.engine.core.Input.*;
import com.base.engine.math.Vector3f;

public class FreeMove extends SceneComponent {

	private int forwardKey, backKey, leftKey, rightKey;
	private float speed;

	public FreeMove(int forwardKey, int backKey, int leftKey, int rightKey, float speed) {
		this.forwardKey = forwardKey;
		this.backKey = backKey;
		this.leftKey = leftKey;
		this.rightKey = rightKey;
		this.speed = speed;
	}

	public FreeMove(float speed) {
		this(KEY_W, KEY_S, KEY_A, KEY_D, speed);
		this.speed = speed;
	}

	@Override
	public void input(float delta) {

		float moveAmount = (float) (speed * delta);

		/*
		 * Add Any Motivations To Movement Before The Move Method Is Called. NOTE: You
		 * Do Not Need To Use Input.getKeyDown Because It Automatically Returns The Key
		 * If It Is Down.
		 */
		if (getKey(KEY_LSHIFT)) {
			moveAmount = (float) (5 * delta);
		}

		if (getKey(forwardKey)) {
			move(super.getTransform().getRotation().getForward(), moveAmount);
		}
		if (getKey(leftKey)) {
			move(super.getTransform().getRotation().getLeft(), moveAmount);
		}
		if (getKey(rightKey)) {
			move(super.getTransform().getRotation().getRight(), moveAmount);
		}
		if (getKey(backKey)) {
			move(super.getTransform().getRotation().getForward(), -moveAmount);
		}

	}

	public void move(Vector3f dir, float amt) {
		super.getTransform().setPosition(super.getTransform().getPosition().add(dir.mul(amt)));
	}

	public int getForwardKey() {
		return forwardKey;
	}

	public void setForwardKey(int forwardKey) {
		this.forwardKey = forwardKey;
	}

	public int getBackKey() {
		return backKey;
	}

	public void setBackKey(int backKey) {
		this.backKey = backKey;
	}

	public int getLeftKey() {
		return leftKey;
	}

	public void setLeftKey(int leftKey) {
		this.leftKey = leftKey;
	}

	public int getRightKey() {
		return rightKey;
	}

	public void setRightKey(int rightKey) {
		this.rightKey = rightKey;
	}

	public float getSpeed() {
		return speed;
	}

	public void setSpeed(float speed) {
		this.speed = speed;
	}
}
