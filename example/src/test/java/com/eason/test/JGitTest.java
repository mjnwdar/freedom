package com.eason.test;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;

import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.api.InitCommand;
import org.eclipse.jgit.api.errors.GitAPIException;
import org.eclipse.jgit.lib.Repository;
import org.eclipse.jgit.lib.StoredConfig;
import org.eclipse.jgit.transport.RefSpec;
import org.eclipse.jgit.transport.RemoteConfig;
import org.eclipse.jgit.transport.URIish;

public class JGitTest {
    public static void main(String[] args) {
        Repository repo = null;
        Git git = null;
        String path = "d:/testjgit";
        InitCommand init = new InitCommand();
        init.setBare(false).setDirectory(new File(path));
        try {
            git = init.call();
            repo = git.getRepository();

            StoredConfig config = repo.getConfig();
            RemoteConfig remoteConfig = new RemoteConfig(config, "origin");
            // �������Զ�˵�ַ
            URIish uri = new URIish("git://github.com/wahyd4/testjgit");
            // �����ĸ���֧
            RefSpec refSpec = new RefSpec("+refs/head/*:refs/remotes/origin/*");
            // ��������
            remoteConfig.addFetchRefSpec(refSpec);
            remoteConfig.addPushRefSpec(refSpec);
            remoteConfig.addURI(uri);
            remoteConfig.addPushURI(uri);
            // ��������
            remoteConfig.update(config);
            // ���浽�����ļ���
            config.save();
        } catch (GitAPIException e) {
            e.printStackTrace();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
