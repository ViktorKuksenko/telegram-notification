package io.jenkins.plugins.sample;

import bot.JenkinsTelegramBot;
import edu.umd.cs.findbugs.annotations.NonNull;
import hudson.Extension;
import hudson.FilePath;
import hudson.Launcher;
import hudson.model.*;
import hudson.tasks.*;
import jenkins.tasks.SimpleBuildStep;
import lombok.SneakyThrows;
import org.kohsuke.stapler.DataBoundConstructor;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

import java.io.IOException;
import java.io.PrintStream;

public class PostNotificationBuilder extends Notifier implements SimpleBuildStep {

    @DataBoundConstructor
    public PostNotificationBuilder() throws TelegramApiException {
    }

    @Override
    public BuildStepMonitor getRequiredMonitorService() {
        return BuildStepMonitor.NONE;
    }

    @Extension
    public static final class DescriptorImpl extends BuildStepDescriptor<Publisher> {

        @Override
        public boolean isApplicable(Class<? extends AbstractProject> jobType) {
            return true;
        }

        @Override
        public String getDisplayName() {
            return "Telegram - Jenkins notification plugin";
        }
    }

    @SneakyThrows
    @Override
    public void perform(@NonNull Run<?, ?> run,
                        @NonNull FilePath workspace,
                        @NonNull Launcher launcher,
                        @NonNull TaskListener listener) throws InterruptedException, IOException {
        Result result = run.getResult();
        PrintStream prinstream = listener.getLogger();

        prinstream.println("dlmfkjdksls;fnjdklsfjskdsjsfksdjfdkfjgkdfdlsngf,mdcdnjgrkksdvnthldrtknv");
        prinstream.println(result);
        TelegramBotsApi botsApi = new TelegramBotsApi(DefaultBotSession.class);

        try {
            botsApi.registerBot(new JenkinsTelegramBot(result.toString()));
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }
}
