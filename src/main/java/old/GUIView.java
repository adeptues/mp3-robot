package old;

import java.awt.BorderLayout;
//import java.awt.CardLayout;
//import java.awt.FlowLayout;
//import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
//import java.awt.event.MouseMotionAdapter;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.*;
//import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
//import javax.swing.event.AncestorEvent;
//import javax.swing.event.AncestorListener;
//import javax.swing.event.ListSelectionEvent;
//import javax.swing.event.ListSelectionListener;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 * This code was edited or generated using CloudGarden's Jigloo
 * SWT/Swing GUI Builder, which is free for non-commercial
 * use. If Jigloo is being used commercially (ie, by a corporation,
 * company or business for any purpose whatever) then you
 * should purchase a license for each developer using Jigloo.
 * Please visit www.cloudgarden.com for details.
 * Use of Jigloo implies acceptance of these licensing terms.
 * A COMMERCIAL LICENSE HAS NOT BEEN PURCHASED FOR
 * THIS MACHINE, SO JIGLOO OR THIS CODE CANNOT BE USED
 * LEGALLY FOR ANY CORPORATE OR COMMERCIAL PURPOSE.
 */
public class GUIView extends javax.swing.JFrame implements View {

    private JMenuItem helpMenuItem;
    private JMenu jMenu5;
    private JPanel mianPanel;
    private JMenuItem addSongItem;
    private JPanel westPanel;
    private JPanel centerPanel;
    private JList playListLists;
    private JList songsList;
    private JPanel southPanel;
    private JButton displayLists;
    private JMenuItem deleteMenuItem;
    private JSeparator jSeparator1;
    private JMenuItem pasteMenuItem;
    private JMenuItem copyMenuItem;
    private JMenu jMenu4;
    private JMenuItem exitMenuItem;
    private JSeparator jSeparator2;
    private JMenu jMenu3;
    private JMenuBar jMenuBar1;
    private Controller controller;
    //private PlayListModel model;
    private JButton sortButton;
    private JPanel recordCenterPanel;
    private JPanel centerNorthPanel;
    private JPanel playBackPanel;
    private JPanel southWestPanel;
    private JPanel recorderCenter;
    private JPanel northPanel;
    private JButton saveToBtn;
    private JLabel saveLocation;
    private JLabel recordNotify;
    private JButton stopButton;
    private JButton recordBtn;
    private JPanel mainPanel;
    private JPanel recordinPane;
    private JTabbedPane jTabbedPane1;
    private JButton nextBtn;
    private JLabel artLabel;
    private JPanel eastPanel;
    private JButton newPlayListButton;
    private JLabel jLabel1;
    private JCheckBox shuffleOption;
    private JPanel northCenter;
    private JLabel timeLabel;
    private JPanel northSouthCenter;
    private JButton stopBtn;
    private JPanel centerSouthCenterPanel;
    private JLabel songLabel;
    private JPanel centerSouthPanel;
    private JButton playButton;
    private JButton deletePlayListButton;
    private Song[] copySong;
    private String pathName;

    /**
     * Auto-generated main method to display this JFrame
     */
    /*
    public static void main(String[] args) {
    SwingUtilities.invokeLater(new Runnable() {
    public void run() {
    GUIView inst = new GUIView();
    inst.setLocationRelativeTo(null);
    inst.setVisible(true);
    }
    });
    }
     */
    public GUIView(Controller controller) {
        super("MP3 Player");
        this.controller = controller;
        initGUI();
    }

    private void getSongToAdd() {
        JFileChooser fileChooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("MP3 files", "mp3");
        fileChooser.setFileFilter(filter);
        // 1 for canel 0 for approve
        fileChooser.setMultiSelectionEnabled(true);
        int returnVal = fileChooser.showOpenDialog(this);

        if (returnVal == 0) {
            File[] files = fileChooser.getSelectedFiles();
            int index = playListLists.getSelectedIndex();
            if (index != -1) {
                boolean check = controller.addFile(files, index);
                //boolean check2 = controller.addSongToPlayList(0);
                if ((!check)) {
                    JOptionPane.showMessageDialog(this, "Error adding song, song not added");
                }
            }


        } else {
            //do nothing
        }
    }

    private File saveTo() {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setMultiSelectionEnabled(false);
        //1 for cancel 0 for approve
        int returnVal = fileChooser.showSaveDialog(this);
        if (returnVal == 0) {
            File file = fileChooser.getSelectedFile();
            return file;
        } else {
            return null;
        }

    }

    private void displayPlayLists() {
        PlayList[] playLists;

        playLists = controller.getAllPlayLists();
        playListLists.setListData(playLists);

        for (int i = 0; i < playLists.length; i++) {
            System.out.println(playLists[i]);
        }
    }

    public void rename() {
        String name = GraphicalInputPrompt.getString("Please enter a new Name");
        int index = playListLists.getSelectedIndex();
        ListModel list = playListLists.getModel();
        PlayList playlist = (PlayList) list.getElementAt(index);
        playlist.setName(name);
        controller.addPlayListAtIndex(index, playlist);
    }

    public boolean getShuffle() {
        return shuffleOption.isSelected();
    }

    private void initGUI() {
        try {
            {
                this.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
                {
                    jTabbedPane1 = new JTabbedPane();
                    getContentPane().add(jTabbedPane1, BorderLayout.CENTER);
                    jTabbedPane1.setPreferredSize(new java.awt.Dimension(635, 272));
                    {
                        mianPanel = new JPanel();
                        jTabbedPane1.addTab("PlayBack", null, mianPanel, null);
                        BorderLayout mianPanelLayout = new BorderLayout();
                        mianPanel.setLayout(mianPanelLayout);
                        {
                            southPanel = new JPanel();
                            BorderLayout southPanelLayout = new BorderLayout();
                            southPanel.setLayout(southPanelLayout);
                            mianPanel.add(southPanel, BorderLayout.SOUTH);
                            {
                                southWestPanel = new JPanel();
                                BoxLayout southWestPanelLayout = new BoxLayout(southWestPanel, javax.swing.BoxLayout.Y_AXIS);
                                southWestPanel.setLayout(southWestPanelLayout);
                                southPanel.add(southWestPanel, BorderLayout.WEST);
                                southWestPanel.setBorder(BorderFactory.createTitledBorder(null, "Play list Controls", TitledBorder.LEADING, TitledBorder.DEFAULT_POSITION));
                                {
                                    displayLists = new JButton();
                                    southWestPanel.add(displayLists);
                                    displayLists.setText("show Play lists");
                                    displayLists.addActionListener(new ActionListener() {

                                        public void actionPerformed(ActionEvent evt) {
                                            displayPlayLists();
                                        }
                                    });
                                }
                                {
                                    deletePlayListButton = new JButton();
                                    southWestPanel.add(deletePlayListButton);
                                    deletePlayListButton.setText("Delete PlayList");
                                    deletePlayListButton.addActionListener(new ActionListener() {

                                        public void actionPerformed(ActionEvent evt) {
                                            int index = playListLists.getSelectedIndex();
                                            //ListModel list = playListLists.getModel();
                                            //PlayList playlist = (PlayList) list.getElementAt(index);
                                            controller.deletePlayList(index);
                                            displayPlayLists();
                                        }
                                    });
                                }
                                {
                                    sortButton = new JButton();
                                    southWestPanel.add(sortButton);
                                    sortButton.setText("Sort by Artist   ");
                                    sortButton.addActionListener(new ActionListener() {

                                        public void actionPerformed(ActionEvent evt) {
                                            int index = playListLists.getSelectedIndex();
                                            controller.sortArtist(index);
                                            displayPlayLists();
                                        }
                                    });
                                }
                                {
                                    newPlayListButton = new JButton();
                                    southWestPanel.add(newPlayListButton);
                                    newPlayListButton.setText("New Play List  ");
                                    newPlayListButton.addActionListener(new ActionListener() {

                                        public void actionPerformed(ActionEvent evt) {


                                            if (!controller.newPlayList()) {
                                                JOptionPane.showMessageDialog(null, "Failed to create Play List");
                                            }
                                            displayPlayLists();
                                        }
                                    });
                                }
                            }
                        }
                        {
                            centerPanel = new JPanel();
                            BorderLayout centerPanelLayout = new BorderLayout();
                            centerPanelLayout.setHgap(5);
                            mianPanel.add(centerPanel, BorderLayout.CENTER);
                            centerPanel.setLayout(centerPanelLayout);
                            {
                                ListModel songsListModel =
                                        new DefaultComboBoxModel(
                                        new String[]{"No songs loaded..."});
                                songsList = new JList();
                                centerPanel.add(songsList, BorderLayout.CENTER);
                                songsList.setModel(songsListModel);
                                songsList.addMouseListener(new MouseAdapter() {

                                    public void mouseClicked(MouseEvent evt) {
                                        if (evt.getClickCount() == 1) {
                                            int index = songsList.getSelectedIndex();
                                            ListModel list = songsList.getModel();
                                            try {
                                                Song song = (Song) list.getElementAt(index);
                                                if (song.getAlbumArt() != null) {
                                                    try {
                                                        BufferedImage bImage = ImageIO.read(song.getAlbumArt());
                                                        ImageIcon icon = new ImageIcon(bImage);
                                                        artLabel.setText("");
                                                        artLabel.setIcon(icon);
                                                    } catch (IOException e) {
                                                        artLabel.setText("No Album Art");
                                                        // TODO Auto-generated catch block
                                                        //e.printStackTrace();
                                                    }
                                                }
                                            } catch (Exception e) {
                                                artLabel.setText("No Album Art");
                                            }



                                        }
                                    }
                                });
                                JScrollPane scrollBar = new JScrollPane(songsList);
                                centerPanel.add(scrollBar, BorderLayout.CENTER);

                            }
                            {
                                westPanel = new JPanel();
                                BorderLayout westPanelLayout = new BorderLayout();
                                westPanel.setLayout(westPanelLayout);
                                centerPanel.add(westPanel, BorderLayout.WEST);
                                {
                                    ListModel playListListsModel =
                                            new DefaultComboBoxModel(
                                            new String[]{"No play list loaded"});
                                    playListLists = new JList();
                                    westPanel.add(playListLists, BorderLayout.CENTER);
                                    playListLists.setModel(playListListsModel);
                                    playListLists.addMouseListener(new MouseAdapter() {

                                        public void mouseClicked(MouseEvent e) {
                                            if (e.getClickCount() == 1) {
                                                ListModel list = playListLists.getModel();
                                                int size;
                                                PlayList playlist = (PlayList) list.getElementAt(playListLists.getSelectedIndex());
                                                size = playlist.getSongs().length;
                                                jLabel1.setText(size + " Songs");
                                                songsList.setListData(playlist.getSongs());
                                            }
                                        }
                                    });
                                }
                            }
                            {
                                centerSouthPanel = new JPanel();
                                BorderLayout centerSouthPanelLayout = new BorderLayout();
                                centerSouthPanel.setLayout(centerSouthPanelLayout);
                                centerPanel.add(centerSouthPanel, BorderLayout.SOUTH);
                                {
                                    northSouthCenter = new JPanel();
                                    centerSouthPanel.add(northSouthCenter, BorderLayout.NORTH);
                                    {
                                        songLabel = new JLabel();
                                        northSouthCenter.add(songLabel);
                                        songLabel.setText("Song not Playing");
                                    }
                                    {
                                        timeLabel = new JLabel();
                                        northSouthCenter.add(timeLabel);
                                        timeLabel.setText("Time");
                                    }
                                }
                                {
                                    centerSouthCenterPanel = new JPanel();
                                    centerSouthPanel.add(centerSouthCenterPanel, BorderLayout.CENTER);
                                }
                            }
                            {
                                northCenter = new JPanel();
                                BorderLayout northCenterLayout = new BorderLayout();
                                northCenter.setLayout(northCenterLayout);
                                centerPanel.add(northCenter, BorderLayout.NORTH);
                                {
                                    playBackPanel = new JPanel();
                                    northCenter.add(playBackPanel, BorderLayout.WEST);
                                    {
                                        playButton = new JButton();
                                        playBackPanel.add(playButton);
                                        playButton.setIcon(new ImageIcon(getClass().getClassLoader().getResource("resourceIcons/playBtn.png")));
                                        playButton.setToolTipText("Start Playing");
                                        playButton.addActionListener(new ActionListener() {

                                            public void actionPerformed(ActionEvent evt) {
                                                int index = songsList.getSelectedIndex();
                                                ListModel list = songsList.getModel();
                                                Song song = (Song) list.getElementAt(index);
                                                songLabel.setText("Now Playing " + song.getSongName() + " By " + song.getArtist() + " From " + song.getAlbum());
                                                try {
                                                    controller.playSong(song);
                                                } catch (URISyntaxException e) {

                                                    e.printStackTrace();
                                                }
                                            }
                                        });
                                    }
                                    {
                                        stopBtn = new JButton();
                                        playBackPanel.add(stopBtn);
                                        stopBtn.setIcon(new ImageIcon(getClass().getClassLoader().getResource("resourceIcons/roundStop.png")));
                                        stopBtn.setToolTipText("Stop Playing");
                                        stopBtn.addActionListener(new ActionListener() {

                                            public void actionPerformed(ActionEvent evt) {
                                                controller.closeMP3();
                                            }
                                        });
                                    }
                                    {
                                        nextBtn = new JButton();
                                        playBackPanel.add(nextBtn);
                                        nextBtn.setIcon(new ImageIcon(getClass().getClassLoader().getResource("resourceIcons/nextBtn.png")));
                                        nextBtn.setToolTipText("Next Song");
                                        nextBtn.addActionListener(new ActionListener() {

                                            public void actionPerformed(ActionEvent evt) {
                                                if (shuffleOption.isSelected()) {
                                                    shuffle();
                                                } else {
                                                    int index = songsList.getSelectedIndex();
                                                    index++;
                                                    ListModel list = songsList.getModel();
                                                    Song song = (Song) list.getElementAt(index);
                                                    songLabel.setText("Now Playing " + song.getSongName() + " By " + song.getArtist() + " From " + song.getAlbum());
                                                    try {
                                                        controller.closeMP3();
                                                        controller.playSong(song);
                                                    } catch (URISyntaxException e) {
                                                        // TODO Auto-generated catch block
                                                        e.printStackTrace();
                                                    }
                                                }
                                            }
                                        });
                                    }
                                }
                                {
                                    centerNorthPanel = new JPanel();
                                    northCenter.add(centerNorthPanel, BorderLayout.CENTER);
                                    {
                                        jLabel1 = new JLabel();
                                        centerNorthPanel.add(jLabel1);
                                        jLabel1.setText("Songs");
                                    }
                                    {
                                        shuffleOption = new JCheckBox();
                                        centerNorthPanel.add(shuffleOption);
                                        shuffleOption.setText("Shuffle");
                                    }
                                }
                            }
                            {
                                eastPanel = new JPanel();
                                BorderLayout jPanel1Layout = new BorderLayout();
                                centerPanel.add(eastPanel, BorderLayout.EAST);
                                eastPanel.setLayout(jPanel1Layout);
                                {
                                    artLabel = new JLabel();
                                    eastPanel.add(artLabel, BorderLayout.CENTER);
                                    artLabel.setText("No Album Art");
                                }
                            }
                        }
                    }
                    {
                        recordinPane = new JPanel();
                        BorderLayout recordinPaneLayout = new BorderLayout();
                        recordinPane.setLayout(recordinPaneLayout);
                        jTabbedPane1.addTab("Recording", null, recordinPane, null);
                        {
                            mainPanel = new JPanel();
                            BorderLayout mainPanelLayout = new BorderLayout();
                            recordinPane.add(mainPanel, BorderLayout.CENTER);
                            mainPanel.setLayout(mainPanelLayout);
                            {
                                recordCenterPanel = new JPanel();
                                BorderLayout recordCenterPanelLayout = new BorderLayout();
                                recordCenterPanel.setLayout(recordCenterPanelLayout);
                                mainPanel.add(recordCenterPanel, BorderLayout.CENTER);
                                {
                                    northPanel = new JPanel();
                                    recordCenterPanel.add(northPanel, BorderLayout.NORTH);
                                    {
                                        saveToBtn = new JButton();
                                        northPanel.add(saveToBtn);
                                        saveToBtn.setText("Save To ...");
                                        saveToBtn.addActionListener(new ActionListener() {

                                            public void actionPerformed(ActionEvent evt) {
                                                File file = saveTo();
                                                if (file != null) {
                                                    String pathName = file.getPath();
                                                    saveLocation.setText(file.getName());
                                                    GUIView.this.pathName = pathName;
                                                }

                                            }
                                        });
                                    }
                                    {
                                        recordBtn = new JButton();
                                        northPanel.add(recordBtn);
                                        recordBtn.setText("Start");
                                        recordBtn.addActionListener(new ActionListener() {

                                            public void actionPerformed(ActionEvent evt) {
                                                String fileName = GUIView.this.pathName;
                                                if (fileName != null) {
                                                    recordNotify.setText("Recording...");
                                                    controller.startRecord(fileName);
                                                }


                                            }
                                        });
                                    }
                                    {
                                        stopButton = new JButton();
                                        northPanel.add(stopButton);
                                        stopButton.setText("Stop");
                                        stopButton.addActionListener(new ActionListener() {

                                            public void actionPerformed(ActionEvent evt) {
                                                controller.stopRecord(false);
                                                recordNotify.setText("Stopped Recording");
                                            }
                                        });
                                    }
                                    {
                                        recordNotify = new JLabel();
                                        northPanel.add(recordNotify);
                                        recordNotify.setText("Not Recording");
                                    }
                                    {
                                        saveLocation = new JLabel();
                                        northPanel.add(saveLocation);
                                        saveLocation.setText("No save file selected");
                                    }
                                }
                                {
                                    recorderCenter = new JPanel();
                                    BorderLayout recorderCenterLayout = new BorderLayout();
                                    recorderCenter.setLayout(recorderCenterLayout);
                                    recordCenterPanel.add(recorderCenter, BorderLayout.CENTER);
                                }
                            }
                        }
                    }
                }
                this.addWindowListener(new WindowAdapter() {

                    public void windowClosing(WindowEvent e) {
                        controller.saveData();
                        System.exit(0);
                    }
                });
            }
            this.setSize(651, 342);
            {
                jMenuBar1 = new JMenuBar();
                setJMenuBar(jMenuBar1);
                {
                    jMenu3 = new JMenu();
                    jMenuBar1.add(jMenu3);
                    jMenu3.setText("File");
                    {
                        addSongItem = new JMenuItem();
                        jMenu3.add(addSongItem);
                        addSongItem.setText("Add Songs");
                        addSongItem.setBounds(70, 21, 69, 21);
                        addSongItem.addActionListener(new ActionListener() {

                            public void actionPerformed(ActionEvent evt) {
                                getSongToAdd();


                            }
                        });
                    }
                    {
                        jSeparator2 = new JSeparator();
                        jMenu3.add(jSeparator2);
                    }
                    {
                        exitMenuItem = new JMenuItem();
                        jMenu3.add(exitMenuItem);
                        exitMenuItem.setText("Exit");
                    }
                }
                {
                    jMenu4 = new JMenu();
                    jMenuBar1.add(jMenu4);
                    jMenu4.setText("Edit");
                    {
                        copyMenuItem = new JMenuItem();
                        jMenu4.add(copyMenuItem);
                        copyMenuItem.setText("Copy");
                        copyMenuItem.addActionListener(new ActionListener() {

                            public void actionPerformed(ActionEvent evt) {
                                int[] index = songsList.getSelectedIndices();
                                ListModel list = songsList.getModel();
                                copySong = new Song[index.length];
                                for (int i = 0; i < index.length; i++) {
                                    copySong[i] = (Song) list.getElementAt(index[i]);
                                }
                                //copySong = (Song) list.getElementAt(index);


                            }
                        });
                    }
                    {
                        pasteMenuItem = new JMenuItem();
                        jMenu4.add(pasteMenuItem);
                        pasteMenuItem.setText("Paste");
                        pasteMenuItem.addActionListener(new ActionListener() {

                            public void actionPerformed(ActionEvent evt) {
                                int index = playListLists.getSelectedIndex();
                                ListModel list = playListLists.getModel();
                                PlayList playlist = (PlayList) list.getElementAt(index);
                                for (int i = 0; i < copySong.length; i++) {
                                    playlist.addSong(copySong[i]);
                                }
                                controller.addPlayListAtIndex(index, playlist);

                            }
                        });
                    }
                    {
                        jSeparator1 = new JSeparator();
                        jMenu4.add(jSeparator1);
                    }
                    {
                        deleteMenuItem = new JMenuItem();
                        jMenu4.add(deleteMenuItem);
                        deleteMenuItem.setText("Rename");
                        deleteMenuItem.addActionListener(new ActionListener() {

                            public void actionPerformed(ActionEvent evt) {
                                rename();
                            }
                        });
                    }
                }
                {
                    jMenu5 = new JMenu();
                    jMenuBar1.add(jMenu5);
                    jMenu5.setText("Help");
                    {
                        helpMenuItem = new JMenuItem();
                        jMenu5.add(helpMenuItem);
                        helpMenuItem.setText("Help");
                        helpMenuItem.addActionListener(new ActionListener() {

                            public void actionPerformed(ActionEvent evt) {
                                showHelp();
                            }
                        });
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void showHelp() {
        JOptionPane.showMessageDialog(this, "This is a java based mp3 player it plays\n"
                + " mp3s and allows some playlist management as well as recording.\n"
                + " uses the following libraries jlayer, jakarta regex, my id3 and db40");
    }

    public void shuffle() {
        //play next song at random
        ListModel list = songsList.getModel();
        Random generator = new Random();
        int nextRandom = generator.nextInt(list.getSize());
        Song song = (Song) list.getElementAt(nextRandom);
        songLabel.setText("Now Playing " + song.getSongName() + " By " + song.getArtist() + " From " + song.getAlbum());
        try {
            controller.closeMP3();
            controller.playSong(song);
        } catch (URISyntaxException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @Override
    public void notifyGUI(boolean check) {
        if (check) {
            timeLabel.setText("Song Playing");
        } else {
            timeLabel.setText("Song Finished");
            if (shuffleOption.isSelected()) {
                shuffle();//shuffle to next song at random

            }
        }


    }

    public void updateTime(int a) {
        timeLabel.setText("Time:" + a);

    }
}
