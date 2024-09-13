/*
 * MIT License
 * 
 * Copyright (c) 2024 Rui Baptista
 * 
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 * 
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 * 
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package multiFrame;

import java.awt.FileDialog;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.util.Arrays;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.UIManager;

public class MultiFrame {
	
	public static void main(String[] args) throws Exception {
		System.out.println("Java version: " + System.getProperty("java.version"));
		UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());

		Locale locale = new Locale.Builder().setLanguage("en").build();
		if (Arrays.asList(new String[] {"fr_FR", "pt_PT"})
				.contains(Locale.getDefault().toString()))
			locale = Locale.getDefault();
		ResourceBundle res = ResourceBundle.getBundle("res.bundle", locale);

		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new GridLayout(2, 1));

		frame.add(new JButton(new AbstractAction(res.getString("file_dialog")) {
			private static final long serialVersionUID = 1L;

			@Override
			public void actionPerformed(ActionEvent e) {
				FileDialog dialog = new FileDialog(frame, res.getString("file_open"), FileDialog.LOAD);
				dialog.setVisible(true);
			}
		}));

		frame.add(new JButton(new AbstractAction(res.getString("file_chooser")) {
			private static final long serialVersionUID = 1L;

			@Override
			public void actionPerformed(ActionEvent e) {
				JFileChooser dialog = new JFileChooser();
				dialog.showOpenDialog(frame);
			}
		}));

		frame.setSize(680, 480);
		frame.setVisible(true);
	}

}
