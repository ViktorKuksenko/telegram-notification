package io.jenkins.plugins.sample;

import edu.umd.cs.findbugs.annotations.NonNull;
import hudson.Extension;
import hudson.FilePath;
import hudson.Launcher;
import hudson.model.*;
import hudson.tasks.*;
import jenkins.tasks.SimpleBuildStep;
import org.kohsuke.stapler.DataBoundConstructor;

import java.io.IOException;
import java.io.PrintStream;

public class PostNotificationBuilder extends Notifier implements SimpleBuildStep {

    @DataBoundConstructor
    public PostNotificationBuilder() {
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

    @Override
    public void perform(@NonNull Run<?, ?> run,
                        @NonNull FilePath workspace,
                        @NonNull Launcher launcher,
                        @NonNull TaskListener listener) throws InterruptedException, IOException {
        Result result = run.getResult();
        PrintStream prinstream = listener.getLogger();

        prinstream.println("dlmfkjdksls;fnjdklsfjskdsjsfksdjfdkfjgkdfdlsngf,mdcdnjgrkksdvnthldrtknv");
        prinstream.println(result);
    }
}
