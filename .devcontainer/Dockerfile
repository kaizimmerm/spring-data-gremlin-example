# [Choice] Java version: 8, 11, 15
ARG VARIANT=11
FROM mcr.microsoft.com/vscode/devcontainers/java:${VARIANT}

# Install Maven
ARG MAVEN_VERSION=""
RUN su vscode -c "source /usr/local/sdkman/bin/sdkman-init.sh && sdk install maven \"${MAVEN_VERSION}\""

# Install additional OS packages.
RUN curl -sL https://aka.ms/InstallAzureCLIDeb | sudo bash
