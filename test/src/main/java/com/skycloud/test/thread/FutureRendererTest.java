package com.skycloud.test.thread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

public class FutureRendererTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

class FutureRenderer {
	private final ExecutorService executor = null;

	void renderPage(CharSequence source) throws Exception {

		final List<ImageInfo> imageInfos = scanForImageInfo(source);

		Callable<List<ImageData>> task = new Callable<List<ImageData>>() {
			public List<ImageData> call() {
				List<ImageData> result = new ArrayList<ImageData>();

				for (ImageInfo imageInfo : imageInfos)
					result.add(imageInfo.downloadImage());

				return result;
			}
		};

		Future<List<ImageData>> future = executor.submit(task);

		renderText(source);

		try {
			List<ImageData> imageData = future.get();
			for (ImageData data : imageData)
				renderImage(data);
		} catch (InterruptedException e) {
			// Re-assert the thread's interrupted status
			Thread.currentThread().interrupt();
			// We don't need the result, so cancel the task too
			future.cancel(true);
		} catch (ExecutionException e) {
			throw launderThrowable(e.getCause());
		}
	}

	private Exception launderThrowable(Throwable cause) {
		return null;
	}

	private void renderImage(ImageData data) {

	}

	private void renderText(CharSequence source) {

	}

	private List<ImageInfo> scanForImageInfo(CharSequence source) {
		return null;
	}
}

class ImageData {

}

class ImageInfo {

	public ImageData downloadImage() {
		return null;
	}

}
