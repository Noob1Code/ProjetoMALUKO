/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelos.constants;

import java.awt.TextField;
import javax.swing.JTextField;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

/**
 *
 * @author Gabriel Braga <ninjagamer9795286@gmail.com>
 * @date 25/11/2024
 * @brief Class Constraints
 */
public class Constraints {

    public static void setTextFieldInteger(JTextField txt) {
        txt.setDocument(new PlainDocument() {
            @Override
            public void insertString(int offs, String str, AttributeSet a) throws BadLocationException {
                if (str != null && str.matches("\\d*")) {
                    super.insertString(offs, str, a);
                }
            }
        });
    }

    public static void setTextFieldMaxLength(JTextField txt, int max) {
        txt.setDocument(new PlainDocument() {
            @Override
            public void insertString(int offs, String str, AttributeSet a) throws BadLocationException {
                if (str != null && (getLength() + str.length() <= max)) {
                    super.insertString(offs, str, a);
                }
            }
        });
    }

    public static void setTextFieldDouble(JTextField txt) {
        txt.setDocument(new PlainDocument() {
            @Override
            public void insertString(int offs, String str, AttributeSet a) throws BadLocationException {
                if (str != null && str.matches("\\d*([\\.]\\d*)?")) {
                    super.insertString(offs, str, a);
                }
            }
        });
    }

    public static void setTextFieldLettersAndSpaces(JTextField txt) {
        txt.setDocument(new PlainDocument() {
            @Override
            public void insertString(int offs, String str, AttributeSet a) throws BadLocationException {
                if (str != null && str.matches("[a-zA-Zá-úÁ-Úà-ùÀ-Ùâ-ûÂ-Ûã-õÃ-Õä-üÄ-ÜçÇ ]*")) {
                    super.insertString(offs, str, a);
                }
            }
        });
    }

    public static void setTextFieldDoubleBetweenZeroAndOne(JTextField txt) {
        txt.setDocument(new PlainDocument() {
            @Override
            public void insertString(int offs, String str, AttributeSet a) throws BadLocationException {
                if (str != null && str.matches("\\d*([\\.]\\d*)?")) {
                    try {
                        String newValue = getText(0, getLength()) + str;
                        double value = Double.parseDouble(newValue);
                        if (value >= 0 && value <= 1) {
                            super.insertString(offs, str, a);
                        }
                    } catch (NumberFormatException | BadLocationException ignored) {
                    }
                }
            }
        });
    }
}
