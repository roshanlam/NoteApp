package gui;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import structures.Book;
import structures.Section;


public class Reader extends javax.swing.JFrame {

    Book main = new Book();
    DefaultListModel bookSections = new DefaultListModel();
    int indexSelected = -1;
    String noteName = "Unnamed section";
    Section selectedSection;

    public Reader() {
        initComponents();
    }
    private void setSelectedSection(Section section){
        this.selectedSection = section;
        taNote.setText(selectedSection.getContent());
    }
    
    @SuppressWarnings("unchecked")
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        taNote = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        tfName = new javax.swing.JTextField();
        btnAssignNote = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
        btnNewTopic = new javax.swing.JButton();
        btnDeleteTopic = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        btnBookName = new javax.swing.JTextField();
        btnSave = new javax.swing.JButton();
        btnLoad = new javax.swing.JButton();
        lblPrompt = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        taNote.setColumns(20);
        taNote.setLineWrap(true);
        taNote.setRows(5);
        taNote.setEnabled(false);
        taNote.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                taNoteKeyTyped(evt);
            }
        });
        jScrollPane1.setViewportView(taNote);

        jLabel1.setText("Name:");

        btnAssignNote.setText("Assign Note");
        btnAssignNote.setEnabled(false);
        btnAssignNote.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAssignNoteActionPerformed(evt);
            }
        });

        jList1.setModel(bookSections);
        jList1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jList1MouseClicked(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jList1MouseReleased(evt);
            }
        });
        jList1.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                jList1ValueChanged(evt);
            }
        });
        jScrollPane2.setViewportView(jList1);

        btnNewTopic.setText("Add New Topic");
        btnNewTopic.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewTopicActionPerformed(evt);
            }
        });

        btnDeleteTopic.setText("Delete Topic");
        btnDeleteTopic.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteTopicActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 48)); // NOI18N
        jLabel2.setText("BurgeNote");

        jLabel3.setText("Name:");

        btnSave.setText("Save");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        btnLoad.setText("Load");
        btnLoad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoadActionPerformed(evt);
            }
        });

        lblPrompt.setText("enter filename to load or save to/from Desktop");
        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel1)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(tfName)
                            .addComponent(btnNewTopic, javax.swing.GroupLayout.DEFAULT_SIZE, 117, Short.MAX_VALUE)
                            .addComponent(btnDeleteTopic, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 408, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnAssignNote, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 318, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnBookName))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(btnLoad, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(lblPrompt, javax.swing.GroupLayout.Alignment.TRAILING))))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(btnBookName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnSave)
                            .addComponent(btnLoad))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblPrompt)))
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(btnAssignNote))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 13, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(tfName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 13, Short.MAX_VALUE)
                        .addComponent(btnNewTopic)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 286, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnDeleteTopic)
                        .addGap(14, 14, 14))))
        );

        pack();
    }// </editor-fold>                        

    private void btnAssignNoteActionPerformed(java.awt.event.ActionEvent evt) {                                              
        String theNote = taNote.getText();
        if (theNote != null && !theNote.equals("")){
            selectedSection.setContent(theNote);
        }
        btnAssignNote.setEnabled(false);
    }                                             

    
    private void jList1MouseReleased(java.awt.event.MouseEvent evt) {                                     
        showItsContent();
    }                                    

    private void jList1MouseClicked(java.awt.event.MouseEvent evt) {                                    
        jList1.setEnabled(true);
    }                                   

    private void btnNewTopicActionPerformed(java.awt.event.ActionEvent evt) {                                            
        String topicName = tfName.getText();
        if (topicName!=null && !topicName.equals("")){
            if (!bookSections.contains(topicName)){
                addToLists(new Section(topicName));
                System.out.println("You entered something new.");
            }
        }
    }                                           

    private void btnDeleteTopicActionPerformed(java.awt.event.ActionEvent evt) {                                               
        if (selectedSection != null){
            removeFromLists();
            taNote.setText("");
        }
        else{
            
        }
    }                                              

    private void taNoteKeyTyped(java.awt.event.KeyEvent evt) {                                
        if (!main.isEmpty()){
            btnAssignNote.setEnabled(true);
        }
    }                               

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {                                        
        try {
            FileOutputStream fout = new FileOutputStream(javax.swing.filechooser.FileSystemView.getFileSystemView().getHomeDirectory()+"\\"+btnBookName.getText());
            ObjectOutputStream oos = new ObjectOutputStream(fout);
            oos.writeObject(main);
            fout.close();
            oos.close();
        } catch (Exception ex) {}
        
    }                                       

    private void btnLoadActionPerformed(java.awt.event.ActionEvent evt) {                                        
        File f = new File(javax.swing.filechooser.FileSystemView.getFileSystemView().getHomeDirectory()+"\\"+btnBookName.getText());
        if(f.exists() && !f.isDirectory()) { 
            try {
                FileInputStream fin = new FileInputStream(f);
                ObjectInputStream ois = new ObjectInputStream(fin);
                bookSections.clear();
                main = (Book) ois.readObject();
                System.out.println(main.getAllWords().get(0).getTitle());
                for (int i = 0; i < main.getAllWords().size(); i++){
                    bookSections.addElement(main.getAllWords().get(i).getTitle());
                }
            } catch (FileNotFoundException ex) {} catch (IOException ex) { } catch (ClassNotFoundException ex) {}
            
        }
    }                                       

    private void jList1ValueChanged(javax.swing.event.ListSelectionEvent evt) {                                    
       showItsContent();
    }                                   
    
    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Reader.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Reader.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Reader.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Reader.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Reader().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify                     
    private javax.swing.JButton btnAssignNote;
    private javax.swing.JTextField btnBookName;
    private javax.swing.JButton btnDeleteTopic;
    private javax.swing.JButton btnLoad;
    private javax.swing.JButton btnNewTopic;
    private javax.swing.JButton btnSave;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JList<String> jList1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblPrompt;
    private javax.swing.JTextArea taNote;
    private javax.swing.JTextField tfName;
    // End of variables declaration                   

    private void addToLists(Section newSection) {
        if (main.takeInk(newSection)) {
            // then we need a new element in the jList
            bookSections.addElement(newSection.getTitle());

        }
    }

    private void clearTextArea() {
        taNote.setText("");
    }

    private void removeFromLists() {
        bookSections.remove(indexSelected);
        main.remove(selectedSection);
    }

    private void showItsContent() {
            indexSelected = jList1.getSelectedIndex();
        if(indexSelected != -1){
            // set the text of the text area to the content selected
            taNote.setEnabled(true);
            Section sectionChosen = main.getAllWords().get(indexSelected);
            setSelectedSection(sectionChosen);
            System.out.println(indexSelected + taNote.getText());
        }    
    
    }
   
}
