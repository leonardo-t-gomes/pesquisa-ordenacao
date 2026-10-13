package pesquisaexercicio;

public class MenuPrincipal extends javax.swing.JFrame {

    private StringBuffer palavraDigitada;

    public MenuPrincipal() {
        initComponents();
        palavraDigitada = new StringBuffer();
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtAreaTexto = new javax.swing.JTextArea();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtPesquisa = new javax.swing.JTextField();
        txtOcorrencia = new javax.swing.JTextField();
        btnLimpar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Texto");

        txtAreaTexto.setColumns(20);
        txtAreaTexto.setRows(5);
        jScrollPane1.setViewportView(txtAreaTexto);

        jLabel2.setText("Pesquisa: ");

        jLabel3.setText("Ocorrencia: ");

        txtPesquisa.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtPesquisaKeyTyped(evt);
            }
        });

        txtOcorrencia.setEnabled(false);

        btnLimpar.setText("Limpar");
        btnLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimparActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtOcorrencia, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel1)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnLimpar)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 420, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(32, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtOcorrencia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnLimpar)
                .addContainerGap(80, Short.MAX_VALUE))
        );

        pack();
    }

    private void txtPesquisaKeyTyped(java.awt.event.KeyEvent evt) {
        char c = evt.getKeyChar();
        if (!Character.isISOControl(c)) {
            palavraDigitada.append(c);
        } else if (c == '\b' && palavraDigitada.length() > 0) {
            palavraDigitada.deleteCharAt(palavraDigitada.length() - 1);
        }
        
        String texto = txtAreaTexto.getText();
        String pesquisa = palavraDigitada.toString();
        
        // Limpa os destaques anteriores
        javax.swing.text.Highlighter highlighter = txtAreaTexto.getHighlighter();
        highlighter.removeAllHighlights();
        
        int ocorrencia = 0;
        
        if (!pesquisa.isEmpty() && !texto.isEmpty()) {
            int lastIndex = 0;
            String textoLower = texto.toLowerCase();
            String pesquisaLower = pesquisa.toLowerCase();
            
            // Cria o pintor de fundo com cor amarela para o destaque
            javax.swing.text.Highlighter.HighlightPainter painter = 
                new javax.swing.text.DefaultHighlighter.DefaultHighlightPainter(java.awt.Color.YELLOW);
            
            while ((lastIndex = textoLower.indexOf(pesquisaLower, lastIndex)) != -1) {
                ocorrencia++;
                try {
                    // Adiciona o destaque visual no JTextArea
                    highlighter.addHighlight(lastIndex, lastIndex + pesquisa.length(), painter);
                } catch (javax.swing.text.BadLocationException ex) {
                    ex.printStackTrace();
                }
                lastIndex += pesquisa.length();
            }
        }
        
        txtOcorrencia.setText(String.valueOf(ocorrencia));
    }

    private void btnLimparActionPerformed(java.awt.event.ActionEvent evt) {
        txtAreaTexto.setText("");
        txtPesquisa.setText("");
        txtOcorrencia.setText("");
        palavraDigitada = new StringBuffer();
        // Remove os destaques ao limpar
        txtAreaTexto.getHighlighter().removeAllHighlights();
    }

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception ex) {
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MenuPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLimpar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea txtAreaTexto;
    private javax.swing.JTextField txtOcorrencia;
    private javax.swing.JTextField txtPesquisa;
    // End of variables declaration//GEN-END:variables
}
